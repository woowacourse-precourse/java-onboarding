package onboarding;

import java.util.*;

public class Problem7 {
    public static HashMap<String,List<String>> getFriends(List<List<String>> friends) {
        HashMap<String,List<String>> map = new HashMap<>();

        for (int i = 0; i < friends.size(); i++){
            String friend1 = friends.get(i).get(0);
            String friend2 = friends.get(i).get(1);

            List<String> list1 = map.getOrDefault(friend1, new ArrayList<>());
            List<String> list2 = map.getOrDefault(friend2, new ArrayList<>());
            list1.add(friend2);
            list2.add(friend1);

            map.put(friend1, list1);
            map.put(friend2, list2);
        }

        return map;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
