package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final int MIN = 1;
    private static final int MAX = 1000000;


    public static List<Integer> countMoney(int money, int divMoney[]) {
        List<Integer> count = new ArrayList<>();
        for (Integer units : divMoney) {
            count.add(money / units);
            money %= units;
        }
        return count;
    }

    public static boolean canMoney(int money) {
        if (money >= MIN && money <= MAX) return true;
        return false;
    }
}
