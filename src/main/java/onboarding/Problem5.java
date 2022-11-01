package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static final int[] WON = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        return getCash(money);
    }

    public static List<Integer> getCash(int money) {
        List<Integer> cash = new ArrayList<>();

        for(int won : WON) {
            cash.add(money / won);
            money %= won;
        }
        return cash;
    }
}
