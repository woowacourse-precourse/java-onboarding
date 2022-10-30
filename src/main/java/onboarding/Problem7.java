package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Map<String, ArrayList<String>> friendMap = createFriendMap(friends);

        return answer;
    }

    private static Map<String, ArrayList<String>> createFriendMap(List<List<String>> friends) {
        Map<String, ArrayList<String>> friendMap = new HashMap<>();
        for (List<String> friend : friends) {
            String user1 = friend.get(0);
            String user2 = friend.get(1);
            storeUser(friendMap, user1, user2);
            storeUser(friendMap, user2, user1);
        }
        return friendMap;
    }

    private static void storeUser(Map<String, ArrayList<String>> friendMap, String user1, String user2) {
        ArrayList<String> friendList = friendMap.getOrDefault(user1, new ArrayList<>());
        friendList.add(user2);
        friendMap.put(user1, friendList);
    }
}
