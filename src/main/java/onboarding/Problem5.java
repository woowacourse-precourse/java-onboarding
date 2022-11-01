package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        answer = bank(money);

        return answer;
    }

    private static List<Integer> bank(int money) {
        List<Integer> returnMoney = new ArrayList<>();

        int[] moneyUnit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int m = 0; m < moneyUnit.length; m++) {
            returnMoney.add(m, money / moneyUnit[m]);
            money %= moneyUnit[m];
        }
        return returnMoney;
    }
}
