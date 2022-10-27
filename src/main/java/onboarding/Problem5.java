package onboarding;

import static onboarding.Problem5.MoneyCalculator.calculateMoneyCount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    public static List<Integer> solution(int money) {
        return calculateMoneyCount(money);
    }

    public static class MoneyCalculator {

        public static List<Integer> calculateMoneyCount(int money) {
            int[] moneyTypes = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
            List<Integer> result = new ArrayList<>();

            for (int i : moneyTypes) {
                result.add(money / i);
                money %= i;
            }
            return result;
        }
    }
}
