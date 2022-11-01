package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    public static List<Integer> solution(int money) {
        return getExchangeMonies(money);
    }

    private static List<Integer> getExchangeMonies(int money) {
        List<Integer> exchangeMonies = new ArrayList<>();
        for (MoneyUnit moneyUnit : MoneyUnit.values()) {
            Integer exchangeMoney = moneyUnit.getExchange(money);
            exchangeMonies.add(exchangeMoney);
            money %= moneyUnit.value;
        }
        return exchangeMonies;
    }

    private enum MoneyUnit {
        FIFTY_THOUSAND_WON(50000),
        TEN_THOUSAND_WON(10000),
        FIVE_THOUSAND_WON(5000),
        THOUSAND_WON(1000),
        FIVE_HUNDRED_WON(500),
        HUNDRED_WON(100),
        FIFTY_WON(50),
        TEN_WON(10),
        ONE_WON(1);

        private final int value;

        MoneyUnit(int value) {
            this.value = value;
        }

        public int getExchange(int money) {
            return money / this.value;
        }
    }
}
