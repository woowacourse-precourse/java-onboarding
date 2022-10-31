package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        Map<String, ArrayList<String>> friend_link = new HashMap<>();

        for(List<String> friend : friends){
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);

            ArrayList<String> list1 = friend_link.getOrDefault(friend1, new ArrayList<>());
            list1.add(friend2);
            friend_link.put(friend1, list1);

            ArrayList<String> list2 = friend_link.getOrDefault(friend2, new ArrayList<>());
            list2.add(friend1);
            friend_link.put(friend2, list2);
        }

        return answer;
    }
}
