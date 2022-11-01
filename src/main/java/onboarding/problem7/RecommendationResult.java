package onboarding.problem7;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RecommendationResult {
    private final LinkedHashMap<String, Integer> sorResultMap = new LinkedHashMap<>();
    private final int MAX_LIMIT = 5;
    public List<String> getRecommendResult(Map<String, Integer> acquaintanceResult, Map<String, Integer> visitorResult) {
        mergeResult(acquaintanceResult, visitorResult);

        for (Map.Entry<String, Integer> kv : sortList(acquaintanceResult)) {
            sorResultMap.put(kv.getKey(), kv.getValue());
        }

        return sorResultMap.entrySet()
                .stream()
                .filter(recommend -> recommend.getValue() > RecommendationScore.STRANGER.getScore())
                .map(Map.Entry::getKey)
                .limit(MAX_LIMIT)
                .collect(Collectors.toList());
    }

    private LinkedList<Map.Entry<String, Integer>> sortList(Map<String, Integer> acquaintanceResult) {
        LinkedList<Map.Entry<String, Integer>> list = new LinkedList<>(acquaintanceResult.entrySet());
        list.sort((i1, i2) -> i2.getValue().compareTo(i1.getValue()));
        return list;
    }

    private void mergeResult(Map<String, Integer> acquaintanceResult, Map<String, Integer> visitorResult) {
        visitorResult.forEach((key, value) -> acquaintanceResult.merge(key, value, Integer::sum));
    }
}
