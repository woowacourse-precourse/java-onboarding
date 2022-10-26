package onboarding;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Problem5 {

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        final int[] koreanMoneyUnits = new int[] {
            50000, 10000, 5000, 1000, 500, 100, 10, 1
        };

        Map<Integer, Integer> moneyUnitMap = getMoneyUnitMap(koreanMoneyUnits);
        int cursor = 0;
        while (money > 0) {
            int currentUnit = koreanMoneyUnits[cursor];
            if (money <= currentUnit) {
                cursor += 1;
                continue;
            }

            money -= currentUnit;
            moneyUnitMap.put(currentUnit, moneyUnitMap.get(currentUnit) + 1);
        }

        return answer;
    }

    private static Map<Integer, Integer> getMoneyUnitMap(int[] moneyUnits) {
        Map<Integer, Integer> moneyUnitMap = new LinkedHashMap<>();
        for (int i = 0; i < moneyUnits.length; i++) {
            moneyUnitMap.put(moneyUnits[i], 0);
        }

        return moneyUnitMap;
    }
}
