package onboarding;

import java.util.ArrayList;
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

    private static int divideByUnit (int money, int unit) {
        return money / unit;
    }

    private static int remainderAfterDivide (int money, int unit) {
        return money % unit;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> moneyUnit = new ArrayList<>();
        moneyUnitAdd(moneyUnit);

        for (int unit : moneyUnit) {
            answer.add(divideByUnit(money, unit));
            money = remainderAfterDivide(money, unit);
        }
        return answer;
    }
}
