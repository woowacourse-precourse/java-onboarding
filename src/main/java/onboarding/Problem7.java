package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public static Map<String, Set<String>> getUsersFriends(List<List<String>> friends){
        Map<String, Set<String>> usersFriends = new HashMap<>();
        for (List<String> friend : friends){
            String user1 = friend.get(0);
            String user2 = friend.get(1);
            if (usersFriends.containsKey(user1))
                usersFriends.get(user1).add(user2);
            else {
                usersFriends.put(user1, new HashSet<>());
                usersFriends.get(user1).add(user2);
            }
            if (usersFriends.containsKey(user2))
                usersFriends.get(user2).add(user1);
            else {
                usersFriends.put(user2, new HashSet<>());
                usersFriends.get(user2).add(user1);
            }
        }
        return usersFriends;
    }
}
