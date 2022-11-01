package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final List<Integer> moneyUnit = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
    public static List<Integer> solution(int money) {
        return getResultList(money);
    }

    private static List<Integer> getResultList(int money) {
        List<Integer> result = new ArrayList<>();
        for (int unit : moneyUnit) {
            result.add(changeMoneyByUnit(money, unit));
            money = getRemainMoney(money, unit);
        }
        return result;
    }

    private static int changeMoneyByUnit(int money, int unit) {
        return money / unit;
    }

    private static int getRemainMoney(int money, int unit) {
        return money % unit;
    }
}
