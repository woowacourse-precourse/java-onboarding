package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    private static Map<Integer, Integer> billAndCoin = Map.ofEntries(
            Map.entry(50000, 50000),
            Map.entry(10000, 10000),
            Map.entry(5000, 5000),
            Map.entry(1000, 1000),
            Map.entry(500, 500),
            Map.entry(100, 100),
            Map.entry(50, 50),
            Map.entry(10, 10),
            Map.entry(1, 1)
    );
}
