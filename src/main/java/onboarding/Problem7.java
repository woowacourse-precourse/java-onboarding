package onboarding;

import java.util.*;

public class Problem7 {
    static Set<String> userFriends = new HashSet<>();
    static Map<String, Integer> userToScore = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        getFriends(user, friends);
        getScore(user, friends, visitors);
        return answer;
    }

    public static void getFriends(String user, List<List<String>> friends) {
        for (List<String> friend : friends) {
            if (friend.get(0) == user) {
                userFriends.add(friend.get(1));
            } else if (friend.get(1) == user) {
                userFriends.add(friend.get(0));
            }
        }
    }

    public static void getScore(String user, List<List<String>> friends, List<String> visitors) {
        for (List<String> friend : friends) {
            if (friend.get(0) == user || friend.get(1) == user) {
                continue;
            }
            if (userFriends.contains(friend.get(0))) {
                increaseScore(friend.get(1), 10);
            }
            if (userFriends.contains(friend.get(1))) {
                increaseScore(friend.get(0), 10);
            }
        }

        for (String visitor : visitors) {
            if (userToScore.containsKey(visitor)) {
                increaseScore(visitor, 1);
            }
            userToScore.put(visitor, 1);
        }
    }

    public static void increaseScore(String user, int score) {
        userToScore.put(user, userToScore.getOrDefault(user, 0) + score);
    }
}
