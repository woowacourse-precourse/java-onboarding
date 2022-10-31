package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem5 {

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        Map<Integer, Integer> aiConverter = getMoneyList();
        answer = List.of(0, 0, 0, 0, 0, 0, 0, 0, 0);
        return answer;
    }

    private static Map<Integer, Integer> getMoneyList() {
        List<Integer> tmp = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        Map<Integer, Integer> moneyToIndex = new HashMap<>();
        for(int i = 0; i < tmp.size(); i++) {
            moneyToIndex.put(tmp.get(i), i);
        }
        return moneyToIndex;
    }
}
