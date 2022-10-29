package onboarding.domain;

import java.util.*;
import java.util.stream.Collectors;

public class RecommendBot {
    public static final int RECOMMEND_SCORE_BY_FRIEND = 10;
    public static final int RECOMMEND_SCORE_BY_VISITOR = 1;
    public static final int MAX_SIZE_OF_RECOMMEND_LIST = 5;

    private final HashMap<String, Integer> recommendScore = new HashMap<>();
    private final List<String> userFriends;

    public RecommendBot(String user, List<List<String>> friends, List<String> visitors) {
        userFriends = findUserFriends(user, friends);
        updateRecommendScoreByNumberOfFriend(user, friends);
        updateRecommendScoreByVisitor(visitors);
    }

    private List<String> findUserFriends(String user, List<List<String>> friends) {
        return friends.stream()
                .filter(friend -> isUserFriend(user, friend))
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    private void updateRecommendScoreByNumberOfFriend(String user, List<List<String>> friends) {
        friends.stream()
                .filter(this::includeInUserFriends)
                .flatMap(List::stream)
                .filter(friend -> !includeInUserFriends(friend) && !friend.equals(user))
                .forEach(friend -> updateRecommendScore(friend, RECOMMEND_SCORE_BY_FRIEND));
    }

    private void updateRecommendScoreByVisitor(List<String> visitors) {
        visitors.stream()
                .filter(visitor -> !includeInUserFriends(visitor))
                .forEach(visitor -> updateRecommendScore(visitor, RECOMMEND_SCORE_BY_VISITOR));
    }

    private static boolean isUserFriend(String user, List<String> friend) {
        return friend.contains(user);
    }

    private boolean includeInUserFriends(List<String> friend) {
        return includeInUserFriends(friend.get(0)) || includeInUserFriends(friend.get(1));
    }

    private boolean includeInUserFriends(String friend) {
        return userFriends.contains(friend);
    }

    private void updateRecommendScore(String person, int score) {
        recommendScore.put(person, recommendScore.getOrDefault(person, 0) + score);
    }

    public List<String> getRecommendUser() {
        return recommendScore.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(MAX_SIZE_OF_RECOMMEND_LIST)
                .collect(Collectors.toList());
    }
}
