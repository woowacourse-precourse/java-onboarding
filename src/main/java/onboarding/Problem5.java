package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static int[] moneyArr = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        return exchangeMoney(money);
    }

    private static List<Integer> exchangeMoney(int money) {
        List<Integer> moneyList = new ArrayList<>();
        for (int i = 0; i < moneyArr.length; i++) {
            moneyList.add(money / moneyArr[i]);
            money %= moneyArr[i];
        }

        return moneyList;
    }
}
