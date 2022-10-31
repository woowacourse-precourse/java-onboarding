package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem5 {
    public static Integer[] calc(int money) {
        int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        Integer[] totalMoneyUnit = new Integer[9];
        Arrays.fill(totalMoneyUnit, 0);

        for (int i = 0; i < 9; i++) {
            if (money == 0) {
                break;
            } else if (money >= unit[i]) {
                int div = money / unit[i];
                money = money % unit[i];
                totalMoneyUnit[i] = div;
            }
        }
        return totalMoneyUnit;
    }

    public static List<Integer> solution(int money) {
        // 5만원 부터 1원까지 순서대로 나눈 후 사용한 횟수 배열에 저장
        return Arrays.asList(calc(money));
    }
}
