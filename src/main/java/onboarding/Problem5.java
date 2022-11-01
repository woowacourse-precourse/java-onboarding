package onboarding;

import java.util.*;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return calculationMoney(money);
    }

    private static List<Integer> calculationMoney(int money) {
        List<Integer> result = new ArrayList<>();
        int[] moneyUnits = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int caculatedMoney = money;

        for (int unit: moneyUnits) {
            int amountOfMoney = money / unit;
            caculatedMoney %= unit;
            money -= unit * amountOfMoney;
            result.add(amountOfMoney);
        }

        return result;
    }
}
