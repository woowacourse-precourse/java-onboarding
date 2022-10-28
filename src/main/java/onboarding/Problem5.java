package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    private static final int[] moneys = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> wallet = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if (money < moneys[i]) {
                wallet.add(0);
                continue;
            }
            wallet.add(money / moneys[i]);
            money %= moneys[i];
        }
        return wallet;
    }
}
