package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    private static final int[] MONEY_LIST = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> moneyCount = new ArrayList<>();

        for (int i = 0; i < MONEY_LIST.length; i++) {
            moneyCount.add(money / MONEY_LIST[i]);
            money %= MONEY_LIST[i];
        }

        return moneyCount;
    }
}
