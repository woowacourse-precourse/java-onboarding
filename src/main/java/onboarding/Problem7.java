package onboarding;

import java.util.*;

public class Problem7 {
    private static Map<String, Set<String>> friendsMap;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        friendsMap = new HashMap<>();

        friendsMap.put(user, new HashSet<>());
        for (List<String> friend : friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);
            addFriendsToMap(friend1, friend2);
            addFriendsToMap(friend2, friend1);
        }

        return answer;
    }

    private static void addFriendsToMap(String keyFriend, String valueFriend) {
        if (!friendsMap.containsKey(keyFriend)) {
            friendsMap.put(keyFriend, new HashSet<>());
        }
        friendsMap.get(keyFriend).add(valueFriend);
    }
}
