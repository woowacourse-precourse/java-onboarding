package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Set<String> near = new HashSet<>();
        List<String> far = new ArrayList<>();
        Map<String, Integer> result = new HashMap<>();

        near.addAll(makeNearList(user, friends));
        makeFarList(user, friends, near, far);
        result.putAll(PointToFarList(near, far);
        PointToVisitors(visitors, near, result);

        answer = sortedAnswer(answer, result);
        return answer;
    }

    private static void PointToVisitors(List<String> visitors, Set<String> near, Map<String, Integer> result) {
        for (String name : visitors) {
            if (near.contains(name)) continue;
            int point = 1;
            if (result.get(name) != null) {
                point += (result.get(name));
            }
            result.put(name, point);
        }
    }

    private static Map<String, Integer> PointToFarList(Set<String> near, List<String> far) {
        Map<String, Integer> result = new HashMap<>();
        for (String name : far) {
            int point = 10;
            if (result.get(name) != null && !near.contains(name)) {
                point += (result.get(name));
            }
            result.put(name, point);
        }
        return result;
    }

    private static void makeFarList(String user, List<List<String>> friends, Set<String> near, List<String> far) {
        for (List<String> AB : friends) {
            for (String name : AB) {
                if (near.contains(name) && !AB.contains(user)) {
                    far.addAll(AB);
                }
            }
        }
        removeDuplicateFar(near, far);
    }

    private static void removeDuplicateFar(Set<String> near, List<String> far) {
        for (int i = far.size() - 1; i >= 0; i--) {
            if (near.contains(far.get(i))) {
                far.remove(i);
            }
        }
    }

    private static Set<String> makeNearList(String user, List<List<String>> friends) {
        Set<String> near = new HashSet<>();
        for (List<String> AB : friends) {
            if (AB.contains(user)) near.addAll(AB);
        }
        near.remove(user);
        return near;
    }

    private static List<String> sortedAnswer(List<String> answer, Map<String, Integer> result) {
        int count = 0;

        List<Map.Entry<String, Integer>> entries = result.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());

        for (Map.Entry<String, Integer> entry : entries) {
            if (count > 4) return answer;
            answer.add(entry.getKey());
            count++;
        }
        return answer;
    }
}
