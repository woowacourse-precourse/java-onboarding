package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Problem5 {

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        final int[] koreanMoneyUnits = new int[] {
            50000, 10000, 5000, 1000, 500, 100, 50, 10, 1
        };

        Map<Integer, Integer> moneyUnitMap = getMoneyUnitMap(koreanMoneyUnits);
        int cursor = 0;
        while (cursor < koreanMoneyUnits.length
                && money > 0) {
            int currentUnit = koreanMoneyUnits[cursor];
            if (money < currentUnit) {
                cursor += 1;
                continue;
            }

            money -= currentUnit;
            moneyUnitMap.put(currentUnit, moneyUnitMap.get(currentUnit) + 1);
        }

        for (Integer value : moneyUnitMap.values()) {
            answer.add(value);
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
