package onboarding;

import java.util.*;

public class Problem7 {
    private static Map<String, List<String>> friendsMap;
    private static Map<String, Integer> pointMap;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        friendsMap = new HashMap<>();
        pointMap = new HashMap<>();

        friends.forEach(Problem7::addFriendList);
        friendsMap.get(user).forEach(f -> increaseFriendPoint(f, user));
        increaseVisitorPoint(visitors, user);

        return Collections.emptyList();
    }

    private static void increaseVisitorPoint(List<String> visitors, String user) {
        List<String> userFriends = friendsMap.get(user);

        visitors.stream()
                .filter(v -> !userFriends.contains(v))
                .forEach( v -> pointMap.put(v, pointMap.getOrDefault(v, 0) + 1 ));
    }

    private static void increaseFriendPoint(String friend, String user) {
        List<String> friends = friendsMap.get(friend);
        List<String> userFriends = friendsMap.get(user);

        friends.stream()
                .filter(f -> !f.equals(user) && !userFriends.contains(f))
                .forEach(f -> pointMap.put(f, pointMap.getOrDefault(f, 0) + 10));
    }

    private static void addFriendList(List<String> friend) {
        int flag = -1;

        for (int i = 0 ; i < 2 ; i++) {
            if (!friendsMap.containsKey(friend.get(i))) {
                friendsMap.put(friend.get(i), new ArrayList<>());
            }

            flag *= -1;
            friendsMap.get(friend.get(i)).add(friend.get(i + flag));
        }
    }
}
