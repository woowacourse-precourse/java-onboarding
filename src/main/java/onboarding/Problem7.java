package onboarding;

import java.util.*;

public class Problem7 {
    private static Map<String, Set<String>> friendsMap;
    private static Map<String, Integer> scoreMap;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        friendsMap = new HashMap<>();
        scoreMap = new HashMap<>();

        friendsMap.put(user, new HashSet<>());
        for (List<String> friend : friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);
            addFriendsToMap(friend1, friend2);
            addFriendsToMap(friend2, friend1);
        }
        addVisitorScore(visitors);

        return answer;
    }

    private static void addFriendsToMap(String keyFriend, String valueFriend) {
        if (!friendsMap.containsKey(keyFriend)) {
            friendsMap.put(keyFriend, new HashSet<>());
        }
        friendsMap.get(keyFriend).add(valueFriend);
    }

    private static void addVisitorScore(List<String> visitors) {
        for (String visitor : visitors) {
            if (!scoreMap.containsKey(visitor)) {
                scoreMap.put(visitor, 0);
            }
            scoreMap.put(visitor, scoreMap.get(visitor) + 1);
        }
    }
}
