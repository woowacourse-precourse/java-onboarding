package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static final Map<String, Integer> numbering = new HashMap<>();
    private static final ArrayList<String> numberToNickname = new ArrayList<>();
    private static final ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    private static final Map<String, Integer> scores = new HashMap<>();
    private static final Set<String> friends = new HashSet<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        doNumbering(user, friends);

        initAdjList(friends);

        calFriendsScore();

        calVisitingScore(visitors);

        ArrayList<Map.Entry<String, Integer>> scoreArray =  new ArrayList<>(scores.entrySet());

        scoreArray.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }

            return o2.getValue() - o1.getValue();
        });


        return answer;
    }

    private static void calVisitingScore(List<String> visitors) {
        for (var visitor : visitors) {
            if (friends.contains(visitor)) {
                continue;
            }
            if (scores.containsKey(visitor)) {
                scores.replace(visitor, scores.get(visitor) + 1);
                continue;
            }
            scores.put(visitor, 1);
        }
    }

    private static void calFriendsScore() {
        ArrayList<Boolean> visited = new ArrayList<>();
        for (int i = 0; i < numbering.size(); i++) {
            visited.add(false);
        }
        visited.set(0, true);
        dfs(0, 2, visited);
    }

    private static void dfs(int vertex, int cntLeft, List<Boolean> visited) {
        if (cntLeft == 0) {
            scores.put(numberToNickname.get(vertex), 10);
            return;
        } else if (cntLeft == 1) {
            friends.add(numberToNickname.get(vertex));
        }

        for (int adjVertex : adjList.get(vertex)) {
            if (visited.get(adjVertex)) {
                continue;
            }

            visited.set(adjVertex, true);
            dfs(adjVertex, cntLeft - 1, visited);
        }
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