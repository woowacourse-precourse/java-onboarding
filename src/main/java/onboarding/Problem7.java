package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static final Map<String, Integer> numbering = new HashMap<>();
    private static final ArrayList<String> numberToNickname = new ArrayList<>();
    private static final ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        doNumbering(user, friends);

        initAdjList(friends);

        return answer;
    }

    private static void doNumbering(String user, List<List<String>> edges) {
        int number = 0;
        numbering.put(user, number++);
        numberToNickname.add(user);

        for (var edge : edges) {
            String[] names = new String[2];
            names[0] = edge.get(0);
            names[1] = edge.get(1);

            if (!numbering.containsKey(names[0])) {
                numbering.put(names[0], number++);
                numberToNickname.add(names[0]);
            }

            if (!numbering.containsKey(names[1])) {
                numbering.put(names[1], number++);
                numberToNickname.add(names[1]);
            }
        }

        return;
    }

    private static void initAdjList(List<List<String>> edges) {
        for (int i = 0; i < numbering.size(); i++) {
            adjList.add(new ArrayList<>());
        }

        for (var edge : edges) {
            int u = numbering.get(edge.get(0));
            int v = numbering.get(edge.get(1));

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
    }

}