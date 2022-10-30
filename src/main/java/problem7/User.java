package problem7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class User {
    private final Set<String> friends;
    private final Map<String, Integer> strangersToRecommendationScore = new HashMap<>();

    public User(Set<String> friends) {
        this.friends = friends;
    }
}
