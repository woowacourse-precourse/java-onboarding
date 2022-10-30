package problem7;

import java.util.*;

public class User {
    private final Set<String> friends;
    private final Map<String, Integer> strangersToRecommendationScore = new HashMap<>();

    public User(Collection<String> friends) {
        this.friends = new HashSet<>(friends);
    }
}
