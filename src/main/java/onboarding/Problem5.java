package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        final List<Integer> WON_LIST = List.of(50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1);
        return moneyChanger(WON_LIST, money);
    }

    static List<Integer> moneyChanger(List<Integer> currencyUnitList, int money) {
        List<Integer> changedResult = new ArrayList<>();
        for (Integer currencyUnit : currencyUnitList) {
            changedResult.add(money / currencyUnit);
            money %= currencyUnit;
        }
        return changedResult;
    }
}
