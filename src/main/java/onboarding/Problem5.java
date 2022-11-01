package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> currencies = new ArrayList<>(Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));

        answer = getCount(money, currencies);

        return answer;
    }

    private static List<Integer> getCount(int money, List<Integer> currencies) {
        List<Integer> countCurrencyList = new ArrayList<>();

        for (int currency : currencies) {
            countCurrencyList.add(money / currency);
            money = money % currency;
        }

        return countCurrencyList;
    }
}
