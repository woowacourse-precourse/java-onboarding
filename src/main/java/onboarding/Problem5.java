package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static final int[] CURRENCY_UNITS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1 };
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int leftMoney = money;

        for (int currencyUnit : CURRENCY_UNITS) {
            int count = leftMoney / currencyUnit;
            answer.add(count);
            leftMoney %= currencyUnit;
        }

        return answer;
    }
}
