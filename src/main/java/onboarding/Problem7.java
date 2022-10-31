package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Problem7 {
    static HashMap<String, HashSet<String>> graph = new HashMap<>();
    static HashMap<String, Integer> points = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>(Collections.emptyList());
        initFriendRelationship(friends);
        calculatePoint(user, visitors);
        return makeAnswer(user, answer);
    }

    private static List<String> makeAnswer(String user, List<String> answer) {
        int count = 0;
        for (String target : sortPoints()) {
            if (count >= 5 || points.get(target) == 0) {
                break;
            }
            if (validateTarget(user, target)) {
                continue;
            }
            answer.add(target);
            count += 1;
        }
        return answer;
    }

    private static List<String> sortPoints() {
        List<String> candidates = new ArrayList<>(points.keySet());
        candidates.sort((o1, o2) -> {
            if (points.get(o1).equals(points.get(o2))) {
                return o1.compareTo(o2);
            }
            return points.get(o2) - points.get(o1);
        });
        return candidates;
    }

    private static boolean validateTarget(String user, String target) {
        if (graph.get(user) != null) {
            if (Objects.equals(target, user)) {
                return true;
            }
            if (graph.get(user).contains(target)) {
                return true;
            }
            return points.get(target) <= 0;
        }
        return false;
    }

    private static void calculatePoint(String user, List<String> visitors) {
        for (String visitor : visitors) {
            if (findFriendOnPoints(visitor)) {
                points.put(visitor, 0);
            }
            addPoint(visitor, 1);
        }
        if (graph.get(user) == null) {
            return;
        }
        for (String friend : graph.get(user)) {
            for (String name : graph.get(friend)) {
                if (Objects.equals(name, user)) {
                    continue;
                }
                if (!graph.get(user).contains(name)) {
                    addPoint(name, 10);
                }
            }
        }
    }

    private static void addPoint(String name, Integer point) {
        points.put(name, points.get(name) + point);
    }

    private static void initFriendRelationship(List<List<String>> friends) {
        for (List<String> friend : friends) {
            if (findFriendOnPoints(friend.get(0))) {
                points.put(friend.get(0), 0);
            }
            if (findFriendOnPoints(friend.get(1))) {
                points.put(friend.get(1), 0);
            }
            if (findFriendOnGraph(friend.get(0))) {
                graph.put(friend.get(0), new HashSet<>());
            }
            if (findFriendOnGraph(friend.get(1))) {
                graph.put(friend.get(1), new HashSet<>());
            }
            insertFriend(friend);
        }
    }

    private static boolean findFriendOnPoints(String name) {
        return !points.containsKey(name);
    }

    private static boolean findFriendOnGraph(String name) {
        return !graph.containsKey(name);
    }

    private static void insertFriend(List<String> friend) {
        graph.get(friend.get(0)).add(friend.get(1));
        graph.get(friend.get(1)).add(friend.get(0));
    }

}
