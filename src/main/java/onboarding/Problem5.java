package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {

    private static final int[] MONEY_SIZE = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1 };

    public static List<Integer> solution(int money) {

        Integer[] result = new Integer[9];
        int idx = 0;

        // idx가 더 이상 움직일 수 없거나, money가 0이 될 때까지 반복
        while (money > 0 && idx < MONEY_SIZE.length) {

            if (money >= MONEY_SIZE[idx]) {
                result[idx]++;
                money -= MONEY_SIZE[idx];
            } else {
                idx++;
            }
        }

    }
}
