package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return withdrawCash(money);
    }

    static List<Integer> withdrawCash(int money) {
        Integer[] billAndCoin = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> moneyCount = new ArrayList<>();

        for (Integer cur : billAndCoin) {
            moneyCount.add(money / cur);
            money %= cur;
        }
        return moneyCount;
    }
}
