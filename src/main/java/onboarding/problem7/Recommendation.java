package onboarding.problem7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Recommendation {

    private final Map<String, Integer> recommendScore = new HashMap<>();

    public Recommendation(Users users) {
        for (User user : users.getUsers()) {
            recommendScore.put(user.getName(), 0);
        }
    }

    public List<String> recommend(Map<String, Integer> visitStatistics, List<String> friendsOfMyFriends , List<String> myFriends) {
        addVisitedScore(visitStatistics);
        addFriendsScore(friendsOfMyFriends);
        List<String> recommendation = sortByScore();
        return recommendation.stream()
                .filter(username -> recommendScore.get(username) != 0)
                .filter(username -> !myFriends.contains(username))
                .limit(5)
                .collect(Collectors.toList());
    }

    private List<String> sortByScore() {
        List<String> usernames = new ArrayList<>(recommendScore.keySet());
        usernames.sort((o1, o2) -> recommendScore.get(o2).compareTo(recommendScore.get(o1)));
        return usernames;
    }

    private void addFriendsScore(List<String> friendsOfMyFriends) {
        for (String friendsOfMyFriend : friendsOfMyFriends) {
            recommendScore.put(friendsOfMyFriend, recommendScore.get(friendsOfMyFriend) + 10);
        }
    }

    private void addVisitedScore(Map<String, Integer> visitStatistics) {
        for (String visitor : visitStatistics.keySet()) {
            recommendScore.put(visitor, visitStatistics.get(visitor));
        }
    }
}
