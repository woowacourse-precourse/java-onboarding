package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final List<Integer> typeOfCurrency = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    public static List<Integer> solution(int money) {
        List<Integer> numberOfCurrency = new ArrayList<>(typeOfCurrency.size());

        for (int currency : typeOfCurrency) {
            numberOfCurrency.add(money / currency);
            money %= currency;
        }
        return numberOfCurrency;
    }
}
