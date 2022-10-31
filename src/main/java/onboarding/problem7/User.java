package onboarding.problem7;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private final String name;
    private final List<String> visitor;
    private final List<String> friendList = new ArrayList<>();
    private final List<String> relatedList = new ArrayList<>();
    private final ScoreCalculator scoreCalculator = new ScoreCalculator();

    public User(String userName, List<List<String>> friends, List<String> visitors) {
        this.name = userName;
        generateFriendList(friends);
        this.visitor = generateVisitors(visitors);
        generateRelatedUser(friends);
    }

    public List<String> getRecommendUserList() {
        return scoreCalculator.getHighScoreList(this.relatedList, this.visitor);
    }

    private void generateFriendList(List<List<String>> friends) {
        for (List<String> relation : friends) {
            addFriend(relation);
        }
    }

    private void addFriend(List<String> relation) {
        String user1 = relation.get(0);
        String user2 = relation.get(1);

        if (user1.equals(this.name)) {
            this.friendList.add(user2);
        }

        if (user2.equals(this.name)) {
            this.friendList.add(user1);
        }
    }

    private List<String> generateVisitors(List<String> visitors) {
        for (String friend : friendList) {
            visitors = visitors.stream()
                    .filter(v -> !v.equals(friend))
                    .collect(Collectors.toList());
        }
        return visitors;
    }

    private void generateRelatedUser(List<List<String>> friends) {
        for (List<String> relation : friends) {
            checkRelation(relation);
        }
    }

    private void checkRelation(List<String> relation) {
        for (String friend : this.friendList) {
            addRelatedUser(friend, relation);
        }
    }
    
    private void addRelatedUser(String friend, List<String> relation) {
        String id1 = relation.get(0);
        String id2 = relation.get(1);
        
        if (id1.equals(friend)
                && !id2.equals(this.name)
                && !this.friendList.contains(id2)) {
            relatedList.add(id2);
        }

        if (id2.equals(friend)
                && !this.name.equals(id1)
                && !this.friendList.contains(id1)) {
            relatedList.add(id1);
        }
    }
}

