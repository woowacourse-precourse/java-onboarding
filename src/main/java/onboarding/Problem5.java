package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int[] moneyValues = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        return calculateResult(money, moneyValues);
    }

    private static List<Integer> calculateResult(int money, int[] moneyValues) {
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < moneyValues.length; i++) {
            int count = money / moneyValues[i];
            money %= moneyValues[i];
            results.add(count);
        }

        return results;
    }
}
