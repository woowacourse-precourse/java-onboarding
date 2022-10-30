package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem7 {
    public static final int VISITOR_SCORE = 1;
    public static final int ACQUAINTANCE_SCORE = 10;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> friendsOfUser = findFriendsByUser(user, friends);
        Map<String, Integer> recommendationScore = addAcquaintanceScore(friends, friendsOfUser, user);
        visitors = excludeFriendsFromVisitors(visitors, friendsOfUser);
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

    private static Map<String, Integer> addAcquaintanceScore(List<List<String>> friends, List<String> friendsOfUser, String user) {
        Map<String, Integer> scoreOfAcquaintances = new HashMap<>();
        for (String friendOfUser : friendsOfUser) {
            List<String> acquaintances = findFriendsByUser(friendOfUser, friends);
            acquaintances.remove(user);
            for (String acquaintance : acquaintances) {
                if (scoreOfAcquaintances.containsKey(acquaintance)) {
                    scoreOfAcquaintances.put(acquaintance, scoreOfAcquaintances.get(acquaintance) + ACQUAINTANCE_SCORE);
                }
                if (!scoreOfAcquaintances.containsKey(acquaintance)) {
                    scoreOfAcquaintances.put(acquaintance, ACQUAINTANCE_SCORE);
                }
            }
        }
        return scoreOfAcquaintances;
    }

    private static List<String> findFriendsByUser(String user, List<List<String>> friends) {
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
