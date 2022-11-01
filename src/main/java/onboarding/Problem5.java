package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        int[] currencies = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        answer = countCurrency(money, currencies);

        return answer;
    }

    private static List<Integer> countCurrency(int money, int[] currencies) {
        List<Integer> currencyCounts = new ArrayList<>();

        for (int currency : currencies) {
            int count = (money < currency) ? 0 : money / currency;

            currencyCounts.add(count);
            money %= currency;
        }

        return currencyCounts;
    }
}
