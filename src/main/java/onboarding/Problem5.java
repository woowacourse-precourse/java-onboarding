package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> output = new ArrayList<>();
        int[] arr = {50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1};
        calcMoneyNum(money, output, arr);
        return output;
    }

    // 지폐 갯수를 계산하는 메서드
    private static void calcMoneyNum(int money, List<Integer> output, int[] arr) {
        for (int j : arr) {
            output.add(money / j);
            money %= j;
        }
    }
}