package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static List<Integer> withdraw(int money){
        List<Integer> currencies = new ArrayList<>();

        currencies.add(money / 50000);
        money %= 50000;
        currencies.add(money / 10000);
        money %= 10000;
        currencies.add(money / 5000);
        money %= 5000;
        currencies.add(money / 1000);
        money %= 1000;
        currencies.add(money / 500);
        money %= 500;
        currencies.add(money / 100);
        money %= 100;
        currencies.add(money / 50);
        money %= 50;
        currencies.add(money / 10);
        money %= 10;
        currencies.add(money);

        return currencies;
    }

    public static List<Integer> solution(int money) {
        return withdraw(money);
    }
}
