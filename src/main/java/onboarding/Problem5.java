package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    static final int[] MONEY_UNIT = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};


    public static List<Integer> solution(int money) {
        return countCurrencies(money);
    }

    private static List<Integer> countCurrencies(int money){
        List<Integer> currencies = new ArrayList<>();
        for (int currency : MONEY_UNIT) {
            currencies.add(money / currency);
            money = money % currency;
        }
        return currencies;
    }
}
