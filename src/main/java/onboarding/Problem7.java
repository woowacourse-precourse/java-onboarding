package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem7 {
    public static Map<String, LinkedList<String>> initRelation(List<List<String>> friends) {
        Map<String, LinkedList<String>> graph = new HashMap<>();
        friends.forEach(o -> {
            String id1 = o.get(0);
            String id2 = o.get(1);

            LinkedList<String> relation1 = graph.getOrDefault(id1, new LinkedList<>());
            LinkedList<String> relation2 = graph.getOrDefault(id2, new LinkedList<>());

            relation1.add(id2);
            relation2.add(id1);

            graph.put(id1, relation1);
            graph.put(id2, relation2);
        });

        return graph;
    }

    public static void scoreMutualFriend(Map<String, LinkedList<String>> relation,
                                         Map<String, Integer> scores,
                                         String user) {
        Set<String> friends = new HashSet<>(relation.get(user));
        friends.stream()
                .flatMap(o -> relation.get(o)
                        .stream())
                .forEach(o -> scores.put(o, scores.getOrDefault(o, 0) + 10));
    }

    public static void scoreVisitors(List<String> visitors, Map<String, Integer> scores) {
        visitors.forEach(o -> {
            scores.put(o, scores.getOrDefault(o, 0) + 1);
        });
    }

    public static List<String> recommendFriend(Map<String, LinkedList<String>> relations,
                                               Map<String, Integer> scores,
                                               String user) {
        Set<String> friends = new HashSet<>(relations.get(user));

        return scores.entrySet()
                .stream()
                .filter(o -> !o.getKey()
                        .equals(user))
                .filter(o -> !friends.contains(o.getKey()))
                .filter(o -> o.getValue() != 0)
                .sorted((o1, o2) -> {
                    if (o1.getValue() != o2.getValue()) return o2.getValue() - o1.getValue();
                    return o1.getKey()
                            .compareTo(o2.getKey());
                })
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, LinkedList<String>> relations = initRelation(friends);
        Map<String, Integer> scores = new HashMap<>();

        scoreMutualFriend(relations, scores, user);
        scoreVisitors(visitors, scores);

        return recommendFriend(relations, scores, user);
    }
}
