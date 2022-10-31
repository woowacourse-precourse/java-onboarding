package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        Map<String, List<String>> nearFriend = new HashMap<>();
        for (List<String> friend : friends) {
            if (friend.get(0).equals(user)) {
                continue;
            }
            if (friend.get(1).equals(user)) {
                continue;
            }
            nearFriend.compute(friend.get(0), (key, value) -> value == null ? new ArrayList<>() : value)
                .add(friend.get(1));
        }
        Map<String, Integer> scores = new HashMap<>();
        for (String visitor : visitors) {
            if (!nearFriend.containsKey(visitor)) {
                scores.put(visitor, scores.getOrDefault(visitor, 0) + 1);
            }
        }
        for (List<String> nearFriends : nearFriend.values()) {
            for (String friend : nearFriends) {
                scores.put(friend, scores.getOrDefault(friend, 0) + 10);
            }
        }
        sortedRecommendRanks(answer, scores);
        return answer;
    }

    private static void sortedRecommendRanks(List<String> answer, Map<String, Integer> scores) {
        List<Map.Entry<String, Integer>> scoreList = new LinkedList<>(scores.entrySet());

        scoreList.sort((o1, o2) -> {
            int comparision = (o1.getValue() - o2.getValue()) * -1;
            return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
        });

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : scoreList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        int i = 1;
        for (String scoreKey : sortedMap.keySet()) {
            answer.add(scoreKey);
            if (i == 5) {
                break;
            }
            i++;
        }
    }
}
