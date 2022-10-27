package onboarding;

import java.util.*;

public class Problem7 {
    private static Map<String, List<String>> friendsMap;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        friendsMap = new HashMap<>();

        friends.forEach(Problem7::addFriendList);


        return Collections.emptyList();
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
