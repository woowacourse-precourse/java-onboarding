package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem7 {
    private static Set<String> userFriends = new HashSet<>();
    private static Map<String, Integer> recommendScoreMap = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        userFriends = new HashSet<>();
        recommendScoreMap = new HashMap<>();

        setFriendsOfUser(user, friends);

        increaseMutualScore(user, friends);
        increaseVisitScore(visitors);

        return getRecommendFriends();
    }

    private static List<String> getRecommendFriends() {
        return recommendScoreMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toList());
    }

    private static void setFriendsOfUser(String user, List<List<String>> friends) {
        friends.stream()
                .filter(friend -> friend.contains(user))
                .forEach(userFriends::addAll);

        userFriends.remove(user);
    }

    private static void increaseMutualScore(String user, List<List<String>> friends) {
        friends.stream()
                .filter(friend ->
                        userFriends.contains(friend.get(0)) || userFriends.contains(friend.get(1)))
                .filter(friend ->
                        !(friend.get(0).equals(user) || friend.get(1).equals(user)))
                .forEach(friend -> {
                    increaseOnePersonScore(friend.get(0), 10);
                    increaseOnePersonScore(friend.get(1), 10);
                });
    }

    private static void increaseVisitScore(List<String> visitors) {
        for (String visitor: visitors) {
            increaseOnePersonScore(visitor, 1);
        }
    }

    private static void increaseOnePersonScore(String person, Integer score) {
        if (userFriends.contains(person)) {
            return;
        }
        if (recommendScoreMap.containsKey(person)) {
            int scoreOfPerson = recommendScoreMap.get(person);
            recommendScoreMap.put(person, scoreOfPerson + score);
        } else {
            recommendScoreMap.put(person, score);
        }
    }
}
