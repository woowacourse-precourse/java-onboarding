package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return getMoney(money);
    }

    private static List<Integer> getMoney(int money) {
        // 돈을 반환해주는 메소드
        Integer[] moneyType = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        Integer[] moneyCount = {0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0; i < moneyType.length; i++) {
            moneyCount[i] = money / moneyType[i];
            money %= moneyType[i];
        }
        return Arrays.asList(moneyCount);
    }
}
