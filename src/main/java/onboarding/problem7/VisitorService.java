package onboarding.problem7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VisitorService {

    public Map<String, Integer> getVisitScore(List<String> visitors) {
        Map<String, Integer> results = new HashMap<>();
        visitors.forEach(visitor ->
                results.put(visitor, results.getOrDefault(visitor, 0) + 1));

        return results;
    }

}
