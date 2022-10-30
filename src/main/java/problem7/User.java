package problem7;

import java.util.*;

public class User {
    private static final int VISITORS_SIZE_LOWER_BOUNDS = 0;
    private static final int VISITORS_SIZE_UPPER_BOUNDS = 10_000;
    private static final String ERR_VISITORS_SIZE = "방문자는 0명 이상 10,000명 이하로 입력하세요.";

    private final Set<String> friends;
    private final Map<String, Integer> strangerToRecommendationScore = new HashMap<>();

    public User(Collection<String> friends) {

        this.friends = new HashSet<>(friends);
    }

    public static void validateVisitors(List<String> visitors) {
        if (visitors.size() < VISITORS_SIZE_LOWER_BOUNDS || visitors.size() > VISITORS_SIZE_UPPER_BOUNDS)
            throw new IllegalArgumentException(ERR_VISITORS_SIZE);
    }

    public void calculateRecommendationScoreWith(List<String> visitors) {
        validateVisitors(visitors);

        visitors.stream()
                .filter(visitor -> !friends.contains(visitor))
                .filter(stranger -> strangerToRecommendationScore.containsKey(stranger))
                .forEach(newStranger -> strangerToRecommendationScore.put(newStranger, 1));

        visitors.stream()
                .filter(visitor -> !friends.contains(visitor))
                .filter(stranger -> !strangerToRecommendationScore.containsKey(stranger))
                .forEach(existingStranger -> strangerToRecommendationScore.put(existingStranger
                        , strangerToRecommendationScore.get(existingStranger) + 1));

    }
}
