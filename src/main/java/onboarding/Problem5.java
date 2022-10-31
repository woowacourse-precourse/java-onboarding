package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    private static final int[] WON_UNIT = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        return calculate(money);
    }

    public static List<Integer> calculate(int money) {
        List<Integer> wallet = new ArrayList();

        for (int unit : WON_UNIT) {
            wallet.add(money / unit);
            money = money % unit;
        }

        return wallet;
    }
}
