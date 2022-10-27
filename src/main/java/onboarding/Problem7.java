package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    static Map<String, Integer> excludedUserMap;
    static Map<String, List<String>> friendMap;
    static Map<String, Integer> acquaintanceScoreMap;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        excludedUserMap = new HashMap<>();
        friendMap = new HashMap<>();
        acquaintanceScoreMap = new HashMap<>();
        initFriendMap(friends);
        initExcludeUserMap(user);
        List<String> friendList = friendMap.get(user);
        List<String> acquaintances = findAcquaintances(friendList);
        calculateAcquaintanceScore(acquaintances, visitors);
        return null;
    }

    private static void calculateAcquaintanceScore(List<String> acquaintances,
        List<String> visitors) {
        addScoreWithAcquaintances(acquaintances);
        addScoreWithVisitor(visitors);
    }

    private static void addScoreWithVisitor(List<String> visitors) {
        for (String visitor : visitors) {
            if (excludedUserMap.get(visitor) != null) {
                continue;
            }

            Integer originScore = acquaintanceScoreMap.putIfAbsent(visitor, 1);
            if (originScore != null) {
                acquaintanceScoreMap.put(visitor, originScore + 1);
            }
        }
    }

    private static void addScoreWithAcquaintances(List<String> acquaintances) {
        for (String user : acquaintances) {
            Integer originScore = acquaintanceScoreMap.putIfAbsent(user, 10);
            if (originScore != null) {
                acquaintanceScoreMap.put(user, originScore + 10);
            }
        }
    }

    private static List<String> findAcquaintances(List<String> friendList) {
        List<String> acquaintances = new ArrayList<>();
        for (String friend : friendList) {
            acquaintances.addAll(findUnExcludedAcquaintances(friend));
        }
        return acquaintances;
    }

    private static List<String> findUnExcludedAcquaintances(String friend) {
        List<String> acquaintances = new ArrayList<>();
        for (String acquaintance : friendMap.get(friend)) {
            if (excludedUserMap.get(acquaintance) == null) {
                acquaintances.add(acquaintance);
            }
        }
        return acquaintances;
    }

    private static void initExcludeUserMap(String user) {
        excludedUserMap.put(user, 1);
        for (String friend : friendMap.get(user)) {
            excludedUserMap.put(friend, 1);
        }
    }

    private static void initFriendMap(List<List<String>> friends) {
        for (List<String> friend : friends) {
            String user1 = friend.get(0);
            String user2 = friend.get(1);
            friendMap.computeIfAbsent(user1, k -> new ArrayList<>());
            friendMap.computeIfAbsent(user2, k -> new ArrayList<>());
            friendMap.get(user1).add(user2);
            friendMap.get(user2).add(user1);

        }
    }

}
