package onboarding;

import java.util.*;

public class Problem7 {
    private static int idx = 0;
    private static int[][] arr;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        SortedMap<String, Integer> map = new TreeMap<>();
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();

        initializeMap(user, friends, visitors, map);

        initializeGraph(friends, map, al);

        initializeArray();

        return answer;
    }

    private static void initializeArray() {
        int[][] arr = new int[idx][2]; //arr[i][0] - score, arr[i][1] - mapping
        for (int i = 0; i < idx; i++) {
            arr[i][1] = i;
        }
    }

    private static void initializeGraph(List<List<String>> friends, SortedMap<String, Integer> map, ArrayList<ArrayList<Integer>> al) {
        //그래프 초기화
        for (int i = 0; i < idx; i++) {
            al.add(new ArrayList<>());
        }
        for (List<String> friend : friends) {
            al.get(map.get(friend.get(0))).add(map.get(friend.get(1)));
            al.get(map.get(friend.get(1))).add(map.get(friend.get(0)));
        }
    }

    private static void initializeMap(String user, List<List<String>> friends, List<String> visitors, SortedMap<String, Integer> map) {
        //맵 초기화
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
