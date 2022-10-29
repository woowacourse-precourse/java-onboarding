package onboarding.problem7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VisitorService {

    public Map<String, Integer> getVisitScore(List<String> visitors, List<String> knownFriends) {  // 내친구.
        Map<String, Integer> results = new HashMap<>();
        visitors.stream()
                .filter(visitor -> !knownFriends.contains(visitor))
                .forEach(visitor -> results.put(visitor, results.getOrDefault(visitor, 0) + 1));

        return results;
    }

}
