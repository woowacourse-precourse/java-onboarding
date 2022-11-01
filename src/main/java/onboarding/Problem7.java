package onboarding;

import java.util.*;

public class Problem7 {

    private static List<String> findFriends(String user, List<List<String>> friends) {
        List<String> result = new ArrayList<>();

        for (List<String> f : friends) {
            if (f.get(1).equals(user)) {
                result.add(f.get(0));
            }
        }
        return (result);
    }

    private static Map<String, Integer> calFriends(String user, List<List<String>> friends, List<String> userFriends) {
        Map<String, Integer> points = new HashMap<>();

        for (List<String> f : friends) {
            if (!f.get(1).equals(user)
                 && userFriends.indexOf(f.get(0)) != -1) {
                if (!points.containsKey(f.get(1))) {
                    points.put(f.get(1), 10);
                }
                else {
                    points.put(f.get(1), points.get(f.get(1)) + 10);
                }
            }
        }
        return (points);
    }

    private static List<Map.Entry<String, Integer>> sortByPoint(Map<String, Integer> points) {
        List<Map.Entry<String, Integer>> sortedList = new LinkedList<>(points.entrySet());
        sortedList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        return (sortedList);
    }

    private static void calVisitors(Map<String, Integer> points, List<String> visitors, List<String> userFriends) {
        for (String v : visitors) {
            if (userFriends.indexOf(v) == -1) {
                if (!points.containsKey(v)) {
                    points.put(v, 1);
                } else {
                    points.put(v, points.get(v) + 1);
                }
            }
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        List<String> userFriends = findFriends(user, friends);
        Map<String, Integer> points = calFriends(user, friends, userFriends);

        calVisitors(points, visitors, userFriends);

        for (Map.Entry<String, Integer> point : sortByPoint(points)) {
            answer.add(point.getKey());
            if (answer.size() == 5) {
                break;
            }
        }
        return answer;
    }
}
