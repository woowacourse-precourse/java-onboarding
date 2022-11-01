package onboarding;

import java.util.*;

public class Problem7 {

    private static final Map<String, List<String>> friendMap = new HashMap<String, List<String>>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static void createFriendsList(List<List<String>> friends) {
        for (List<String> friend : friends) {
            String user1 = friend.get(0);
            String user2 = friend.get(1);
            if (!friendMap.containsKey(user1)) {
                friendMap.put(user1, new ArrayList<>());
                friendMap.get(user1).add(user2);
            }else{
                friendMap.get(user1).add(user2);
            }
            if (!friendMap.containsKey(user2)) {
                friendMap.put(user2, new ArrayList<>());
                friendMap.get(user2).add(user1);
            }else{
                friendMap.get(user2).add(user1);
            }
        }
    }
}
