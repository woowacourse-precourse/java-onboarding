package onboarding.problem5;

import java.util.ArrayList;
import java.util.List;

public class Exchange {
    public static List<Integer> getExchangeList(int money) {
        List<Integer> exchangeList = new ArrayList<>();

        for (Money divideValue : Money.values()) {
            exchangeList.add(money / divideValue.value());

            money = money % divideValue.value();
        }

        return exchangeList;
    }
}