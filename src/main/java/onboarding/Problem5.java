package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static final int[] monetaryUnit = new int[] {50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> exchangeResult = new ArrayList<>();

        if (money < 1 || money > 1_000_000) {
            return Collections.emptyList();
        }

        withdrawMoney(exchangeResult, money);

        return exchangeResult;
    }

    private static void withdrawMoney(List<Integer> exchangeResult, int money) {
        int monetaryCount;

        for (int i = 0; i < monetaryUnit.length; i++) {
            monetaryCount = money / monetaryUnit[i];

            exchangeResult.add(monetaryCount);
            money -= (monetaryCount * monetaryUnit[i]);
        }
    }
}
