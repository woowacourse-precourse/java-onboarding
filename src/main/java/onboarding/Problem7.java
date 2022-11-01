package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Problem7 p7 = new Problem7();
        HashMap<String, Integer> recommendation = new HashMap<>();
        List<String> usersFriends = p7.getOnesFriends(friends, user);

        for (String friend : usersFriends) {
            recommendation = p7.getAcquaintanceScore(recommendation, friends, friend, user);
        }

        recommendation = p7.getVisitScore(recommendation, p7.excludeFriend(visitors, usersFriends));

        return recommendation.entrySet()
                .stream()
                .sorted(((Comparator<Map.Entry<String, Integer>>) (o1, o2) -> o2.getValue() - o1.getValue()).thenComparing(Map.Entry.comparingByKey()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private List<String> getOnesFriends(List<List<String>> friends, String user) {
        List<String> result = new ArrayList<>();
        friends.stream().filter(e -> e.contains(user)).forEach(result::addAll);
        return result.stream().filter(element -> !element.equals(user)).collect(Collectors.toList());
    }

    private HashMap<String, Integer> getAcquaintanceScore(HashMap<String, Integer> recommendation, List<List<String>> friends, String userFriend, String user) {
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

    private HashMap<String, Integer> getVisitScore(HashMap<String, Integer> recommendation, List<String> visitors) {
        for (String visitor : visitors) {
            if (recommendation.containsKey(visitor)) {
                recommendation.put(visitor, recommendation.get(visitor) + 1);
            } else {
                recommendation.put(visitor, 1);
            }
        }
        return recommendation;
    }
}
