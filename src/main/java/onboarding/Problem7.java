package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> friendGraph = makeFriendGraph(friends);
        Map<String, Integer> score = calculateScore(user, visitors, friendGraph);

        return score.entrySet().stream()
                .sorted(Collections
                        .reverseOrder(Map.Entry.<String, Integer>comparingByValue())
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(5)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }

    private static Map<String, List<String>> makeFriendGraph(List<List<String>> friends) {
        HashMap<String, List<String>> ret = new HashMap<>();
        for (var friend : friends) {
            ret.computeIfAbsent(friend.get(0), e -> new ArrayList<>()).add(friend.get(1));
            ret.computeIfAbsent(friend.get(1), e -> new ArrayList<>()).add(friend.get(0));
        }
        return ret;
    }

    private static Map<String, Integer> calculateScore(String user, List<String> visitors, Map<String, List<String>> graph) {
        Map<String, Integer> ret = new HashMap<>();
        for (var userFriend : graph.get(user))
            for (var friendOfUserFriend : graph.get(userFriend)) {
                if (graph.get(user).contains(friendOfUserFriend) || friendOfUserFriend.equals(user))
                    continue;
                ret.put(friendOfUserFriend, ret.getOrDefault(friendOfUserFriend, 0) + 10);
            }
        for (var visitor : visitors) {
            if (graph.get(user).contains(visitor))
                continue;
            ret.put(visitor, ret.getOrDefault(visitor, 0) + 1);
        }
        return ret;
    }
}
