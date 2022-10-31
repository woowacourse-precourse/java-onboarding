package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Problem7 {
    static Map<String, Integer> excludedUsers;
    static Map<String, List<String>> friendRelationShips;
    static Map<String, Integer> acquaintanceScores;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        excludedUsers = new HashMap<>();
        friendRelationShips = new HashMap<>();
        acquaintanceScores = new HashMap<>();
        initFriendRelationShips(friends);
        initExcludeUsers(user);
        List<String> friendList = friendRelationShips.get(user);
        List<String> acquaintances = findAcquaintances(friendList);
        calculateAcquaintanceScore(acquaintances, visitors);
        return sortAcquaintanceScore(acquaintanceScores);
    }

    private static List<String> sortAcquaintanceScore(Map<String, Integer> acquaintanceScoreMap) {
        List<Entry<String, Integer>> acquaintanceScoreList = new ArrayList<>(
            acquaintanceScoreMap.entrySet());
        acquaintanceScoreList.sort((score1, score2) -> score2.getValue().compareTo(
            score1.getValue()));
        return acquaintanceScoreList.stream().map(Entry::getKey).collect(Collectors.toList());
    }

    private static void calculateAcquaintanceScore(List<String> acquaintances,
        List<String> visitors) {
        addScoreWithAcquaintances(acquaintances);
        addScoreWithVisitor(visitors);
    }

    private static void addScoreWithVisitor(List<String> visitors) {
        for (String visitor : visitors) {
            if (excludedUsers.get(visitor) != null) {
                continue;
            }

            Integer originScore = acquaintanceScores.putIfAbsent(visitor, 1);
            if (originScore != null) {
                acquaintanceScores.put(visitor, originScore + 1);
            }
        }
    }

    private static void addScoreWithAcquaintances(List<String> acquaintances) {
        for (String user : acquaintances) {
            Integer originScore = acquaintanceScores.putIfAbsent(user, 10);
            if (originScore != null) {
                acquaintanceScores.put(user, originScore + 10);
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
        for (String acquaintance : friendRelationShips.get(friend)) {
            if (excludedUsers.get(acquaintance) == null) {
                acquaintances.add(acquaintance);
            }
        }
        return acquaintances;
    }

    private static void initExcludeUsers(String user) {
        excludedUsers.put(user, 1);
        for (String friend : friendRelationShips.get(user)) {
            excludedUsers.put(friend, 1);
        }
    }

    private static void initFriendRelationShips(List<List<String>> friends) {
        for (List<String> friend : friends) {
            String user1 = friend.get(0);
            String user2 = friend.get(1);
            friendRelationShips.computeIfAbsent(user1, k -> new ArrayList<>());
            friendRelationShips.computeIfAbsent(user2, k -> new ArrayList<>());
            friendRelationShips.get(user1).add(user2);
            friendRelationShips.get(user2).add(user1);

        }
    }

}
