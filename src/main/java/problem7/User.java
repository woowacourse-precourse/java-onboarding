package problem7;

import java.util.*;
import java.util.stream.Collectors;

public class User {
    public static final int RECOMMENDATION_LIMIT = 5;
    private final String name;
    private final Map<String, Integer> recommendationScores = new HashMap<>();

    public User(String name) {
        this.name = name;
        preprocessRecommendationScores();
    }

    private void preprocessRecommendationScores() {
        recommendationScores.clear();

        var friends = FriendConnectionRepository.getFriends(name);

        FriendConnectionRepository.getUsers().stream()
                .filter(person -> !name.equals(person) && !friends.contains(person))
                .forEach(person -> recommendationScores.put(person, 0));
    }

    public List<String> getMostRecommendedAsFriend(List<String> visitors) {
        calculateRecommendationScoreWith(visitors);

        calculateRecommendationScoreWithCommonFriends();

        return getMostRecommended();
    }

    private void calculateRecommendationScoreWith(List<String> visitors) {
        visitors.stream()
                .filter(visitor -> recommendationScores.containsKey(visitor))
                .forEach(stranger ->
                        recommendationScores.put(stranger, recommendationScores.get(stranger) + 1));
    }

    public void calculateRecommendationScoreWithCommonFriends() {
        var friends = FriendConnectionRepository.getFriends(name);

        friends.stream()
                .map(friend -> FriendConnectionRepository.getFriends(friend))
                .flatMap(hisFriends -> hisFriends.stream())
                .filter(user -> !friends.contains(user) && !name.equals(user))
                .forEach(recommended ->
                        recommendationScores.put(recommended, recommendationScores.get(recommended) + 10));
    }

    private List<String> getMostRecommended() {
        List<Map.Entry<String, Integer>> sortedByRecommendationScore = sortRecommendationScores();

        return sortedByRecommendationScore.stream()
                .filter(recommendationScore -> recommendationScore.getValue() > 0)
                .map(recommendationScore -> recommendationScore.getKey())
                .limit(RECOMMENDATION_LIMIT)
                .collect(Collectors.toList());
    }

    private List<Map.Entry<String, Integer>> sortRecommendationScores() {
        List<Map.Entry<String, Integer>> recommendationScoresList = new ArrayList<>(recommendationScores.entrySet());

        Collections.sort(recommendationScoresList, (leftEntry, rightEntry) -> {
            if (leftEntry.getValue() != rightEntry.getValue())
                return rightEntry.getValue() - leftEntry.getValue();
            return leftEntry.getKey().compareTo(rightEntry.getKey());
        });

        return recommendationScoresList;
    }
}
