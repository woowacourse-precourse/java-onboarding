package onboarding;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends,
        List<String> visitors) {

        HashMap<String, Set<String>> friendsMap = makeInitMap(friends);
        HashMap<String, Integer> scoreMap = makeScoreMap();
        Set<String> removeFriendsSet = makeRemoveFriendsSet(user, friendsMap);

        updateFriendsScore(scoreMap, friendsMap, user, removeFriendsSet);
        updateVisitorsScore(scoreMap, visitors, removeFriendsSet);

        List<String> collect = scoreMap.entrySet().stream()
            .sorted(Comparator.comparing((Entry<String, Integer> entry) -> entry.getValue()).reversed()
                .thenComparing((Entry<String, Integer> entry) -> entry.getKey()))
            .map(entry -> entry.getKey())
            .collect(Collectors.toList());
        return collect;
    }

    private static void updateVisitorsScore(Map<String, Integer> scoreMap,
        List<String> visitorsList, Set<String> removeFriendsSet) {

        for (String visitor : visitorsList) {
            if (!removeFriendsSet.contains(visitor)) {
                putValueScore(scoreMap, visitor, 1);
            }
        }
        System.out.println("scoreMap = " + scoreMap);
    }

    private static void updateFriendsScore(Map<String, Integer> scoreMap,
        Map<String, Set<String>> friendsMap, String user, Set<String> removeFriendsSet) {

        Set<String> friendsSet = friendsMap.get(user);

        for (String userFriend : friendsSet) {
            friendsMap.get(userFriend).removeAll(removeFriendsSet);

            for (String friend : friendsMap.get(userFriend)) {
                putValueScore(scoreMap, friend, 10);
            }
        }

        System.out.println("scoreMap = " + scoreMap);
    }

    private static Set<String> makeRemoveFriendsSet(String user, Map<String, Set<String>> friendsMap) {
        Set<String> friendsSet = friendsMap.get(user);
        Set<String> removeFriendsSet = new HashSet<>(Set.of(user));
        removeFriendsSet.addAll(friendsSet);
        return removeFriendsSet;
    }

    private static HashMap<String, Integer> makeScoreMap() {
        return new HashMap<String, Integer>();
    }

    private static HashMap<String, Set<String>> makeInitMap(List<List<String>> friends) {
        HashMap<String, Set<String>> initMap = new HashMap<>();
        for (List<String> friend : friends) {
            putValue(initMap, friend.get(0), friend.get(1));
            putValue(initMap, friend.get(1), friend.get(0));
        }
        return initMap;
    }

    private static void putValue(HashMap<String, Set<String>> initMap, String friend1, String friend2) {
        if (!initMap.containsKey(friend1)) {
            initMap.put(friend1, new HashSet<>(Set.of(friend2)));
            return;
        }
        Set<String> tmpSet = initMap.get(friend1);
        tmpSet.add(friend2);
        initMap.put(friend1, tmpSet);
    }
    private static void putValueScore(Map<String, Integer> scoreMap, String friend, int score) {
        if (!scoreMap.containsKey(friend)) {
            scoreMap.put(friend, score);
            return;
        }
        int currentScore = scoreMap.get(friend);
        currentScore += score;
        scoreMap.put(friend, currentScore);
    }

}
