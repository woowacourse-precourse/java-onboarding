package onboarding;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Problem7 {
    private static final int MAX_RECOMMENDATION_COUNT = 5;
    private static final int MIN_RECOMMENDATION_SCORE = 0;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Friends> userFriends = new HashMap<>();
        Map<String, Integer> scores = new HashMap<>();

        registerFriends(friends, userFriends);
        Friends myFriends = userFriends.get(user);

        calculateVisitorScores(visitors, scores);
        calculateSameFriendsScore(userFriends, scores, myFriends);
        return recommend(user, scores, myFriends);
    }

    private static void registerFriends(List<List<String>> friends, Map<String, Friends> userFriends) {
        friends.forEach(friend -> register(friend, userFriends));
    }

    private static void register(List<String> friend, Map<String, Friends> userFriends) {
        String first = friend.get(0);
        String second = friend.get(1);

        userFriends.computeIfAbsent(first, user -> new Friends());
        userFriends.computeIfAbsent(second, user -> new Friends());
        userFriends.get(first).add(second);
        userFriends.get(second).add(first);
    }

    private static void calculateVisitorScores(List<String> visitors, Map<String, Integer> scores) {
        visitors.forEach(visitor -> scores.put(visitor, scores.getOrDefault(visitor, 0) + 1));
    }

    private static void calculateSameFriendsScore(Map<String, Friends> userFriends, Map<String, Integer> scores, Friends myFriends) {
        for (Map.Entry<String, Friends> userFriend : userFriends.entrySet()) {
            String username = userFriend.getKey();
            Friends friends = userFriend.getValue();

            int sameFriendsScore = myFriends.sameFriendsCount(friends) * 10;
            int score = scores.getOrDefault(username, 0);

            scores.put(username, score + sameFriendsScore);
        }
    }

    private static List<String> recommend(String user, Map<String, Integer> scores, Friends myFriends) {
        return scores.entrySet().stream()
                .filter(predicate(user, myFriends))
                .sorted(comparator())
                .limit(MAX_RECOMMENDATION_COUNT)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static Predicate<Map.Entry<String, Integer>> predicate(String user, Friends myFriends) {
        return score -> notMe(user, score)
                && score.getValue() > MIN_RECOMMENDATION_SCORE
                && myFriends.notContains(score.getKey());
    }

    private static boolean notMe(String user, Map.Entry<String, Integer> score) {
        return !score.getKey().equals(user);
    }

    private static Comparator<Map.Entry<String, Integer>> comparator() {
        return (score1, score2) -> {
            if (score1.getValue().equals(score2.getValue())) {
                return score1.getKey().compareTo(score2.getKey());
            }
            return score2.getValue().compareTo(score1.getValue());
        };
    }
}
