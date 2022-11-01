package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem5 {

    private static final int[] MONEY_SIZE = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1 };

    public static List<Integer> solution(int money) {
        // 배열 초기화
        Integer[] result = new Integer[9];
        for (int i = 0; i < result.length; i++)
            result[i] = 0;
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

        return Arrays.asList(result);
    }
}
