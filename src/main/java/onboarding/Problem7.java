package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> score = new HashMap<>();

        for (List<String> friend : friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);

            if (!map.keySet().contains(friend1)) map.put(friend1, new ArrayList<>());
            if (!map.keySet().contains(friend2)) map.put(friend2, new ArrayList<>());

            map.get(friend1).add(friend2);
            map.get(friend2).add(friend1);
        }

        return answer;
    }
}
