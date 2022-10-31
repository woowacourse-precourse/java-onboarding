package onboarding;

import java.util.*;

public class Problem7 {
    private static int idx = 0;
    private static int[][] arr;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        SortedMap<String, Integer> sortedmap = new TreeMap<>();
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();

        initializeMap(user, friends, visitors, sortedmap);

        initializeGraph(friends, sortedmap, al);

        initializeArray();

        calculateScore(user, visitors, sortedmap, al);

        recommendFriend(answer, sortedmap);

        return answer;
    }

    private static void recommendFriend(List<String> answer, SortedMap<String, Integer> map) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o2[0] - o1[0];
            }
        });

        for (int i = 0; i < 5 && arr[i][0] > 0; i++) {
            for (String s : map.keySet()) {
                if (map.get(s) == arr[i][1]) {
                    answer.add(s);
                    break;
                }
            }
        }
    }

    private static void calculateScore(String user, List<String> visitors, SortedMap<String, Integer> map, ArrayList<ArrayList<Integer>> al) {
        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[idx];
        visited[map.get(user)] = true;
        for (Integer integer : al.get(map.get(user))) {
            deque.addLast(integer);
            visited[integer] = true;
        }
        while (!deque.isEmpty()) {
            int now = deque.pollFirst();
            for (Integer integer : al.get(now)) {
                if (!visited[integer]) {
                    arr[integer][0] += 10;
                }
            }
        }
        for (String visitor : visitors) {
            if (!visited[map.get(visitor)]) {
                arr[map.get(visitor)][0]++;
            }
        }
    }


    private static void initializeArray() {
        arr = new int[idx][2]; //arr[i][0] - score, arr[i][1] - mapping
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
