package onboarding;

import java.util.*;

public class Problem7 {
    //user에 따라 친구 목록을 만드는 map
    public static Map<String, List<String>> getUsersList(List<List<String>> friends){
        Map<String, List<String>> userFriendsList = new HashMap<>();
        for (List<String> friend : friends) {
            if (!userFriendsList.containsKey(friend.get(0)))
                userFriendsList.put(friend.get(0), new ArrayList<>());
            if (!userFriendsList.containsKey(friend.get(1)))
                userFriendsList.put(friend.get(1), new ArrayList<>());
            userFriendsList.get(friend.get(0)).add(friend.get(1));
            userFriendsList.get(friend.get(1)).add(friend.get(0));
        }
        return userFriendsList;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
