package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        SortedMap<String, Integer> map = new TreeMap<>();
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();

        initializeMap(user, friends, visitors, map); 

        return answer;
    }

    private static void initializeMap(String user, List<List<String>> friends, List<String> visitors, SortedMap<String, Integer> map) {
        int idx = 0;
        map.put(user, 0);
        for (List<String> friend : friends) {
            if (!map.containsKey(friend.get(0))) {
                map.put(friend.get(0), 0);
            }
            if (!map.containsKey(friend.get(1))) {
                map.put(friend.get(1), 0);
            }
        }
        for (String visitor : visitors) {
            if (!map.containsKey(visitor)) {
                map.put(visitor, 0);
            }
        }
        for (String s : map.keySet()) {
            map.replace(s, 0, idx++);
        }
    }
}
