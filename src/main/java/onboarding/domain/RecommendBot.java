package onboarding.domain;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class RecommendBot {
    public static final int RECOMMEND_SCORE_BY_FRIEND = 10;

    private final HashMap<String, Integer> recommendScore = new HashMap<>();
    private final List<String> userFriends;

    public RecommendBot(String user, List<List<String>> friends, List<String> visitors) {
        userFriends = findUserFriends(user, friends);
        updateRecommendScoreByNumberOfFriend(user, friends);
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

    private static boolean isUserFriend(String user, List<String> friend) {
        return friend.contains(user);
    }

    private boolean includeInUserFriends(List<String> friend) {
        return includeInUserFriends(friend.get(0)) || includeInUserFriends(friend.get(1));
    }

    private boolean includeInUserFriends(String friend) {
        return userFriends.contains(friend);
    }

    private void updateRecommendScore(String friend, int score) {
        recommendScore.replace(friend, recommendScore.getOrDefault(friend, 0) + score);
    }
}
