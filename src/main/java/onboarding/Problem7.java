package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static Map<String, LinkedList<String>> initGraph(List<List<String>> friends) {
        Map<String, LinkedList<String>> graph = new HashMap<>();
        friends.forEach(o -> {
            String person1 = o.get(0);
            String person2 = o.get(1);

            LinkedList<String> relation1 = graph.getOrDefault(person1, new LinkedList<>());
            LinkedList<String> relation2 = graph.getOrDefault(person2, new LinkedList<>());

            relation1.add(person2);
            relation2.add(person1);

            graph.put(person1, relation1);
            graph.put(person2, relation2);
        });

        return graph;
    }

    public static void scoreFriendToFriend(Map<String, LinkedList<String>> relationGraph,
                                           Map<String, Integer> scores,
                                           String user) {
        Set<String> friends = new HashSet<>(relationGraph.get(user));
        friends.stream()
                .flatMap(o -> relationGraph.get(o).stream())
                .forEach(o -> scores.put(o, scores.getOrDefault(o, 0) + 10));
    }

    public static void scoreVisitors(List<String> visitors, Map<String, Integer> scores) {
        visitors.forEach(o -> {
            int score = scores.getOrDefault(o, 0) + 1;
            scores.put(o, score);
        });
    }

    public static List<String> getResult(Map<String, LinkedList<String>> relationGraph,
                                         Map<String, Integer> scores,
                                         String user) {
        Set<String> friends = new HashSet<>(relationGraph.get(user));

        return scores.entrySet().stream()
                .filter(o -> !o.getKey().equals(user))
                .filter(o -> !friends.contains(o.getKey()))
                .filter(o -> o.getValue() != 0)
                .sorted((o1, o2) -> {
                    if (o1.getValue() != o2.getValue())
                        return o2.getValue() - o1.getValue();

                    return o1.getKey().compareTo(o2.getKey());
                })
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, LinkedList<String>> relationGraph = initGraph(friends);
        Map<String, Integer> scores = new HashMap<>();

        scoreFriendToFriend(relationGraph, scores, user);
        scoreVisitors(visitors, scores);

        return getResult(relationGraph, scores, user);
    }
}
