package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static int[] currencies = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = getNumberOfCurrencies(money);
        return answer;
    }

    private static List<Integer> getNumberOfCurrencies(int money) {
        List<Integer> numberOfCurrencies = new ArrayList<Integer>();

        for (int i = 0; i< currencies.length; i++) {
            numberOfCurrencies.add(money/=currencies[i]);
            money = money%currencies[i];
        }

        return numberOfCurrencies;
    }
}
