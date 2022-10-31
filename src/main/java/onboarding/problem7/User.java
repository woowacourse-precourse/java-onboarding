package onboarding.problem7;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private String name;
    private List<String> visitor;
    private List<String> friendList;
    private List<String> relatedList;
    private ScoreCalculator scoreCalculator = new ScoreCalculator();

    public User(String userName, List<List<String>> friends, List<String> visitors) {
        this.name = userName;
        this.friendList = generateFriendList(userName, friends);
        this.visitor = generateVisitors(visitors);
        this.relatedList = generateRelatedUser(friends);
    }

    public List<String> getRecommendUserList() {
        return scoreCalculator.getHighScoreList(this.relatedList, this.visitor);
    }

    private List<String> generateFriendList(String userName, List<List<String>> friends) {
        return friends.stream()
                .filter((v) -> v.get(1).equals(userName))
                .map((v) -> v.get(0))
                .collect(Collectors.toList());
    }

    private List<String> generateVisitors(List<String> visitors) {
        for (String friend : friendList) {
            visitors = visitors.stream()
                    .filter(v -> !v.equals(friend))
                    .collect(Collectors.toList());
        }
        return visitors;
    }

    private List<String> generateRelatedUser(List<List<String>> friends) {
        return friends.stream()
                .filter((v) -> (!this.name.equals(v.get(1))
                        && !friendList.contains(v.get(1))
                        && friendList.contains(v.get(0))))
                .map((v) -> v.get(1))
                .collect(Collectors.toList());
    }
}
