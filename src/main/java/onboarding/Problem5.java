package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static void moneyUnitAdd (List<Integer> moneyUnit) {
        moneyUnit.add(50000);
        moneyUnit.add(10000);
        moneyUnit.add(5000);
        moneyUnit.add(1000);
        moneyUnit.add(500);
        moneyUnit.add(100);
        moneyUnit.add(50);
        moneyUnit.add(10);
        moneyUnit.add(1);
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        List<Integer> moneyUnit = Collections.emptyList();
        moneyUnitAdd(moneyUnit);

        return answer;
    }
}
