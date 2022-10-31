package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    static Map<String, Integer> points;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        points = new HashMap<>();

        Map<String, List<String>> relationMap = getRelationships(friends, new HashMap<>());
        addRelationPoint(relationMap, user);
        addVisitorPoint(relationMap, visitors, user);

        List<String> answer = new ArrayList<>(points.keySet());
        sort(answer);

        return answer.stream().limit(5).filter(s -> !s.equals(user)).collect(Collectors.toList());
    }


    private static Map<String, List<String>> getRelationships(List<List<String>> friends, HashMap<String, List<String>> relationMap) {
        for (List<String> friend : friends) {
            if (!relationMap.containsKey(friend.get(0))) {
                relationMap.put(friend.get(0), new ArrayList<>());
            }
            if (!relationMap.containsKey(friend.get(1))) {
                relationMap.put(friend.get(1), new ArrayList<>());
            }
            relationMap.get(friend.get(0)).add(friend.get(1));
            relationMap.get(friend.get(1)).add(friend.get(0));
        }
        return relationMap;

    }

    private static void addRelationPoint(Map<String, List<String>> relationMap, String user) {
        relationMap.get(user).stream().map(relationMap::get).forEach(friends -> friends.forEach(Problem7::addRelationPoint));
    }

    private static void addRelationPoint(String s) {
        if (points.containsKey(s)) {
            points.put(s, points.get(s) + 10);
        } else {
            points.put(s, 10);
        }
    }

    private static void addVisitorPoint(Map<String, List<String>> relationMap, List<String> visitors, String user) {
        for (String visitor : visitors) {
            if (relationMap.get(user).contains(visitor)) {
                continue;
            }
            if (points.containsKey(visitor)) {
                points.put(visitor, points.get(visitor) + 1);
            } else {
                points.put(visitor, 1);
            }

        }
    }

    private static void sort(List<String> answer) {
        answer.sort((o1, o2) -> {
            if (points.get(o1) < points.get(o2)) return 1;
            else if (points.get(o1) > points.get(o2)) return -1;
            else {
                if (points.get(o1) == points.get(o2)) {
                    return o1.compareTo(o2);
                }
            }
            return 0;
        });
    }


}
