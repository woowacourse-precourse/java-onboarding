package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static Map<String, List<String>> friendship;
    private static Map<String, Integer> idToScore;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        initFriendshipByFriends(friends);
        calculateScores(user, visitors);
        return getRecommendationsUp2Five(sortRecommendations());
    }

    private static void initFriendshipByFriends(List<List<String>> friends) {
        friendship = new HashMap<>();
        for (List<String> friend : friends) {
            String idA = friend.get(0);
            String idB = friend.get(1);
            friendship.putIfAbsent(idA, new ArrayList<>());
            friendship.putIfAbsent(idB, new ArrayList<>());
            friendship.get(idA).add(idB);
            friendship.get(idB).add(idA);
        }
    }

    private static void calculateScores(String user, List<String> visitors) {
        idToScore = new HashMap<>();
        addScoresByFriendship(user);
        addScoresByVisitors(user, visitors);
    }

    private static Map<String, Integer> addScoresByFriendship(String user) {
        for (String id : friendship.keySet()) {
            if (user.equals(id) || isFriend(user, id)) {
                continue;
            }
            idToScore.put(id, 10 * countSameFriend(user, id));
        }
        return idToScore;
    }

    private static int countSameFriend(String user, String otherUser) {
        int sameFriendCnt = 0;
        for (String friend : friendship.get(otherUser)) {
            if (isFriend(user, friend)) {
                sameFriendCnt++;
            }
        }
        return sameFriendCnt;
    }

    private static void addScoresByVisitors(String user, List<String> visitors) {
        for (String visitor : visitors) {
            if (isFriend(user, visitor)) {
                continue;
            }
            idToScore.put(visitor, idToScore.getOrDefault(visitor, 0) + 1);
        }
    }

    private static boolean isFriend(String user, String otherUser) {
        return friendship.get(user).contains(otherUser);
    }

    private static List<Map.Entry<String, Integer>> sortRecommendations() {
        return idToScore.entrySet().stream()
                .sorted((o1, o2) -> o1.getValue() == o2.getValue()
                        ? o1.getKey().compareTo(o2.getKey())
                        : o2.getValue().compareTo(o1.getValue()))
                .collect(Collectors.toList());
    }

    private static List<String> getRecommendationsUp2Five(List<Map.Entry<String, Integer>> recommendations) {
        List<String> newRecommendations = new ArrayList<>();
        for (Map.Entry<String, Integer> recommendation : recommendations) {
            if (newRecommendations.size() == 5) {
                return newRecommendations;
            }
            newRecommendations.add(recommendation.getKey());
        }
        return newRecommendations;
    }
}
