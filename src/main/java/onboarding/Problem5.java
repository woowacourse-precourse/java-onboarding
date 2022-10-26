package onboarding;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Problem5 {

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        Map<Integer, Integer> moneyUnitMap = getMoneyUnitMap();


        return answer;
    }

    private static Map<Integer, Integer> getMoneyUnitMap() {
        Map<Integer, Integer> moneyUnitMap = new LinkedHashMap<>();

        moneyUnitMap.put(50000, 0);
        moneyUnitMap.put(10000, 0);
        moneyUnitMap.put(5000, 0);
        moneyUnitMap.put(1000, 0);
        moneyUnitMap.put(500, 0);
        moneyUnitMap.put(100, 0);
        moneyUnitMap.put(10, 0);
        moneyUnitMap.put(1, 0);

        return moneyUnitMap;
    }
}
