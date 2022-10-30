package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static final int[] monetaryUnits = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        checkException(money);
        return calMoneySet(money);
    }

    private static List<Integer> calMoneySet(int money) {
        List<Integer> moneySet = new ArrayList<>();

        for (int monetaryUnit : monetaryUnits) {
            moneySet.add(money / monetaryUnit);
            money %= monetaryUnit;
        }

        return moneySet;
    }

    private static void checkException(int money) {
        if (money < 1 || money > 1000000) {
            throw new RuntimeException("돈의 액수가 1보다 작거나 1,000,000을 초과한다");
        }
    }
}
