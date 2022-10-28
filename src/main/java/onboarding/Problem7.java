package onboarding;

import java.util.*;

public class Problem7 {

    private static Map<String, Integer> friendScoreMap;
    private static Map<String, List<String>> friendGraph;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        initFriendGraph(friends);

        computeOfTogetherKnowFriendScore(user);

        computeOfVisitorsScore(visitors);

        return null;
    }

    private static void computeOfVisitorsScore(List<String> visitors) {
        for (String visitor : visitors) {
            Optional.ofNullable(friendScoreMap.computeIfPresent(visitor, (k, v) -> v + 1)).orElse(friendScoreMap.put(visitor, 1));
        }
    }

    private static void computeOfTogetherKnowFriendScore(String user) {
        for (Map.Entry<String, List<String>> entry : friendGraph.entrySet()) {
            String friend = entry.getKey();
            if (!friend.equals(user) && !friendGraph.get(user).contains(friend)) {
                Optional.ofNullable(friendScoreMap.computeIfPresent(friend, (k, v) -> v + 10)).orElse(friendScoreMap.put(friend, 10));
            }
        }
    }

    private static void initFriendGraph(List<List<String>> friends) {
        friendGraph = new HashMap<>();
        friendScoreMap = new HashMap<>();

        for (List<String> relation : friends) {
            String friend1 = relation.get(0);
            String friend2 = relation.get(1);

            List<String> friend1List = friendGraph.getOrDefault(friend1, new ArrayList<>());
            if (friend1List.isEmpty()) {
                friendGraph.put(friend1, friend1List);
            }
            friend1List.add(friend2);

            List<String> friend2List = friendGraph.getOrDefault(friend2, new ArrayList<>());
            if (friend2List.isEmpty()) {
                friendGraph.put(friend2, friend2List);
            }
            friend2List.add(friend1);
        }
    }
}
