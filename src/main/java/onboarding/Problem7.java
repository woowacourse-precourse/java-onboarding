package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    private static final int SAME_FRINED_SCORE = 10;
    private static final int VISIT_TIMELINE_SCORE = 1;
    private static final int INITIAL_SCORE = 0;
    private static final int SHOW_NUMBER_OF_PEOPLE = 5;
    private static Map<String, List<String>> friendship;
    private static Map<String, Integer> idToScore;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        initFriendshipByFriends(friends);
        calculateScores(user, visitors);
        return getRecommendationsForUser(user);
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
        addScoresByVisitors(visitors);
    }

    private static Map<String, Integer> addScoresByFriendship(String user) {
        for (String id : friendship.keySet()) {
            idToScore.put(id, SAME_FRINED_SCORE * countSameFriend(user, id));
        }
        return idToScore;
    }

    private static int countSameFriend(String user, String otherUser) {
        return (int) friendship.get(otherUser).stream()
                .filter(friend -> isFriend(user, friend))
                .count();
    }

    private static boolean isFriend(String user, String otherUser) {
        return friendship.get(user).contains(otherUser);
    }

    private static void addScoresByVisitors(List<String> visitors) {
        for (String visitor : visitors) {
            idToScore.put(visitor, idToScore.getOrDefault(visitor, INITIAL_SCORE) + VISIT_TIMELINE_SCORE);
        }
    }

    private static List<String> getRecommendationsForUser(String user) {
        return idToScore.entrySet().stream()
                .filter(o -> !user.equals(o.getKey()) && !isFriend(user, o.getKey()))
                .sorted((o1, o2) -> compareByRecommendationAlgorithm(o1, o2))
                .limit(SHOW_NUMBER_OF_PEOPLE)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static int compareByRecommendationAlgorithm(Map.Entry<String, Integer> nameToScoreA, Map.Entry<String, Integer> nameToScoreB) {
        Integer scoreA = nameToScoreA.getValue();
        Integer scoreB = nameToScoreB.getValue();
        if (scoreA.equals(scoreB)) {
            String nameA = nameToScoreA.getKey();
            String nameB = nameToScoreB.getKey();
            return nameA.compareTo(nameB);
        }
        return scoreB.compareTo(scoreA);
    }
}
