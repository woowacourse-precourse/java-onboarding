package onboarding;

import java.util.*;

public class Problem7 {

    private static final Map<String, Integer> scores = new HashMap<>();
    private static List<String> userFriends;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        initUserFriends(user, friends);

        getCofriends(friends);
        getVisitors(visitors);

        List<Map.Entry<String, Integer>> candidates = sortScores(user);
        for (int i = 0; i < Math.min(5, candidates.size()); i++) {
            if (candidates.get(i).getValue().equals(100)) {
                break;
            }
            answer.add(candidates.get(i).getKey());
        }
        return answer;
    }

    private static void initUserFriends(String user, List<List<String>> friends) {
        userFriends = new ArrayList<>();
        for (List<String> friend : friends) {
            if (friend.get(0).equals(user)) {
                userFriends.add(friend.get(1));
            } else if (friend.get(1).equals(user)) {
                userFriends.add(friend.get(0));
            }
        }
    }

    private static void getCofriends(List<List<String>> friends) {
        for (List<String> friend : friends) {
            if (userFriends.contains(friend.get(0))) {
                scores.put(friend.get(1), scores.getOrDefault(friend.get(1), 0) + 10);
            }
            if (userFriends.contains(friend.get(1))) {
                scores.put(friend.get(0), scores.getOrDefault(friend.get(0), 0) + 10);
            }
        }
    }

    private static void getVisitors(List<String> visitors) {
        for (String visitor : visitors) {
            if (userFriends.contains(visitor)) {
                continue;
            }
            scores.put(visitor, scores.getOrDefault(visitor, 0) + 1);
        }
    }

    private static List<Map.Entry<String, Integer>> sortScores(String user) {
        scores.remove(user);
        for (String s : scores.keySet()) {
            if (scores.get(s).equals(0)) {
                scores.remove(s);
            }
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(scores.entrySet());
        entryList.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue() - o1.getValue();
        });
        return entryList;
    }
}