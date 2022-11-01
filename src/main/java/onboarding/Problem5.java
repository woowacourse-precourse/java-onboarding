package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final List<Integer> MONETARY_UNIT = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    public static List<Integer> solution(int money) {
        return withdrawMoney(money);
    }

    private static List<Integer> withdrawMoney(int money) {
        List<Integer> wallet = new ArrayList<>();

        for (Integer unit : MONETARY_UNIT) {
            int cnt = getCount(money, unit);
            wallet.add(cnt);
            money %= unit;
        }

        return wallet;
    }

    private static int getCount(int money, Integer unit) {
        return money / unit;
    }
}
