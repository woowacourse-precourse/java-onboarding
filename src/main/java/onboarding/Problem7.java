package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private List<String> getOnesFriends(List<List<String>> friends, String user) {
        List<String> result = new ArrayList<>();
        friends.stream().filter(e -> e.contains(user)).forEach(result::addAll);
        return result.stream().filter(element -> !element.equals(user)).collect(Collectors.toList());
    }

    private HashMap<String, Integer> getAcquaintanceScore(List<List<String>> friends, String userFriend, String user) {
        HashMap<String, Integer> recommendation = new HashMap<>();

        for (List<String> relation : friends) {
            if (!relation.contains(user) && relation.contains(userFriend)) {
                String stranger = relation.stream().filter(e -> !e.equals(userFriend)).findFirst().get();
                if (recommendation.containsKey(stranger)) {
                    recommendation.put(stranger, recommendation.get(stranger) + 10);
                } else {
                    recommendation.put(stranger, 10);
                }
            }
        }
        return recommendation;
    }

    private List<String> excludeFriend(List<String> visitors, List<String> friends) {
        return visitors.stream().filter(e -> !friends.contains(e)).collect(Collectors.toList());
    }

    private HashMap<String, Integer> getVisitScore(List<String> visitors) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String visitor : visitors) {
            if (map.containsKey(visitor)) {
                map.put(visitor, map.get(visitor) + 1);
            } else {
                map.put(visitor, 1);
            }
        }
        return map;
    }


}
