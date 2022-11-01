package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static final int MAX_RECOMMEND_SIZE = 5;
    public static final int FRIEND_IN_COMMON_SCORE = 10;
    public static final int VISITOR_SCORE = 1;
    public static final int MINIMUM_RECOMMEND_SCORE = 1;

    public static final Comparator<Map.Entry<String, Integer>> byValDesc = Map.Entry.comparingByValue(Comparator.reverseOrder());
    public static final Comparator<Map.Entry<String, Integer>> byKeyAsc = Map.Entry.comparingByKey();
    public static final Comparator<Map.Entry<String, Integer>> sortConditions = byValDesc.thenComparing(byKeyAsc);

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Set<String>> userToFriends = getUserToFriendMap(friends);

        Map<String, Integer> idToRecommendScore = getIdToRecommendScore(user, userToFriends, visitors);

        Set<String> userFriends = userToFriends.getOrDefault(user, Set.of());
        Map<String, Integer> recommendableIdsToScore = filterOnlyRecommendable(user, userFriends, idToRecommendScore);

        return getSortedRecommendList(recommendableIdsToScore);
    }

    public static Map<String, Set<String>> getUserToFriendMap(List<List<String>> friends) {
        Map<String, Set<String>> userToFriends = new HashMap<>();

        for (List<String> relation : friends) {
            addFriend(userToFriends, relation.get(0), relation.get(1));
        }


        return userToFriends;
    }

    public static void addFriend(Map<String, Set<String>> userToFriends, String user1, String user2) {
        userToFriends
                .computeIfAbsent(user1, k -> new HashSet<>())
                .add(user2);

        userToFriends
                .computeIfAbsent(user2, k -> new HashSet<>())
                .add(user1);

    }

    public static Map<String, Integer> getFriendsInCommon(Map<String, Set<String>> userToFriends, String user) {
        Map<String, Integer> friendsInCommon = new HashMap<>();

        for (String id : userToFriends.keySet()) {
            friendsInCommon.put(id, getNumberOfFriendsInCommon(userToFriends, user, id));
        }
        return friendsInCommon;
    }

    public static int getNumberOfFriendsInCommon(Map<String, Set<String>> userToFriends, String user, String other) {
        if (user.equals(other)) {
            return 0;
        }

        int count = 0;

        for (String id : userToFriends.keySet()) {

            if (userToFriends.getOrDefault(user, Set.of()).contains(id) && userToFriends.getOrDefault(other, Set.of()).contains(id)) {
                count += 1;
            }
        }
        return count;
    }

    public static Map<String, Integer> getIdToRecommendScore(String user, Map<String, Set<String>> userToFriends, List<String> visitors) {
        Map<String, Integer> idToRecommendScore = new HashMap<>();

        Map<String, Integer> friendsInCommon = getFriendsInCommon(userToFriends, user);

        updateFriendInCommonScore(idToRecommendScore, friendsInCommon);

        updateVisitorScore(idToRecommendScore, visitors);

        return idToRecommendScore;
    }

    public static void updateFriendInCommonScore(Map<String, Integer> recommendScores, Map<String, Integer> friendsInCommon) {
        for (String other : friendsInCommon.keySet()) {
            recommendScores.put(other, friendsInCommon.getOrDefault(other, 0) * FRIEND_IN_COMMON_SCORE);
        }
    }

    public static void updateVisitorScore(Map<String, Integer> recommendScores, List<String> visitors) {
        for (String id : visitors) {
            recommendScores
                    .put(id, recommendScores.getOrDefault(id, 0) + VISITOR_SCORE);
        }
    }

    private static Map<String, Integer> filterOnlyRecommendable(String user, Set<String> userFriends, Map<String, Integer> idToRecommendScore) {
        return idToRecommendScore
                .entrySet()
                .stream()
                .filter(entry -> !userFriends.contains(entry.getKey()))
                .filter(entry -> !entry.getKey().equals(user))
                .filter(entry -> entry.getValue() >= MINIMUM_RECOMMEND_SCORE)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static List<String> getSortedRecommendList(Map<String, Integer> recommendScores) {


        return recommendScores.entrySet()
                .stream()
                .sorted(sortConditions)
                .limit(MAX_RECOMMEND_SIZE)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }
}
