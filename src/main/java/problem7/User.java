package problem7;

import java.util.*;

public class User {
    private final Set<String> friends;
    private final Map<String, Integer> strangersToRecommendationScore = new HashMap<>();

    public User(Collection<String> friends) {
        this.friends = new HashSet<>(friends);
    }

    public void calculateRecommendationScoreWith(List<String> visitors) {
        visitors.stream()
                .filter(visitor -> !friends.contains(visitor))
                .filter(stranger -> strangersToRecommendationScore.containsKey(stranger))
                .forEach(newStranger -> strangersToRecommendationScore.put(newStranger, 1));

        visitors.stream()
                .filter(visitor -> !friends.contains(visitor))
                .filter(stranger -> !strangersToRecommendationScore.containsKey(stranger))
                .forEach(existingStranger -> strangersToRecommendationScore.put(existingStranger
                        , strangersToRecommendationScore.get(existingStranger) + 1));

    }
}
