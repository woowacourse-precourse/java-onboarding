package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem7 {
    public static final int VISITOR_SCORE = 1;
    public static final int ACQUAINTANCE_SCORE = 10;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> friendsOfUser = findFriendsOfOne(user, friends);
        visitors = excludeFriendsFromVisitors(visitors, friendsOfUser);

        Map<String, Integer> recommendationScore = getAcquaintanceScore(friends, friendsOfUser, user);
        addVisitorScore(visitors, recommendationScore);
        sortRecommendationScore(recommendationScore);
        return getRecommendationNames(recommendationScore);
    }

    private static List<String> excludeFriendsFromVisitors(List<String> visitors, List<String> friendsOfUser) {
        List<String> visitorsExceptFriends = new ArrayList<>(visitors);
        friendsOfUser.stream().forEach(friend -> visitorsExceptFriends.remove(friend));
        return visitorsExceptFriends;
    }

    private static List<String> getRecommendationNames(Map<String, Integer> scoreOfAcquaintance) {
        return new ArrayList<>(scoreOfAcquaintance.keySet());
    }

    private static void sortRecommendationScore(Map<String, Integer> scoreOfAcquaintance) {
        scoreOfAcquaintance.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .sorted(Map.Entry.comparingByValue());
    }

    private static void addVisitorScore(List<String> visitors, Map<String, Integer> recommendationScore) {
        for (String visitor : visitors) {
            if (recommendationScore.containsKey(visitor)) {
                recommendationScore.put(visitor, recommendationScore.get(visitor) + VISITOR_SCORE);
            }
            if (!recommendationScore.containsKey(visitor)) {
                recommendationScore.put(visitor, VISITOR_SCORE);
            }
        }
    }

    private static Map<String, Integer> getAcquaintanceScore(List<List<String>> friends, List<String> friendsOfUser, String user) {
        Map<String, Integer> acquaintanceScore = new HashMap<>();
        for (String friendOfUser : friendsOfUser) {
            List<String> acquaintances = findFriendsOfOne(friendOfUser, friends);
            acquaintances.remove(user);
            addAcquaintanceScore(acquaintanceScore, acquaintances);
        }
        return acquaintanceScore;
    }

    private static void addAcquaintanceScore(Map<String, Integer> acquaintanceScore, List<String> acquaintances) {
        for (String acquaintance : acquaintances) {
            if (acquaintanceScore.containsKey(acquaintance)) {
                acquaintanceScore.put(acquaintance, acquaintanceScore.get(acquaintance) + ACQUAINTANCE_SCORE);
            }
            if (!acquaintanceScore.containsKey(acquaintance)) {
                acquaintanceScore.put(acquaintance, ACQUAINTANCE_SCORE);
            }
        }
    }

    private static List<String> findFriendsOfOne(String user, List<List<String>> friends) {
        Set<String> friendsOfUser = new HashSet<>();
        for (List<String> friend : friends) {
            if (friend.contains(user)) {
                friendsOfUser.addAll(friend);
            }
        }
        friendsOfUser.remove(user);
        return new ArrayList<>(friendsOfUser);
    }
}
