package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final int MIN = 1;
    private static final int MAX = 1000000;

    public static List<Integer> solution(int money) {
        if (!canMoney(money)) throw new IllegalArgumentException("제한 사항을 위반하였습니다.");
        int divMoney[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        return countMoney(money, divMoney);

    }

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
