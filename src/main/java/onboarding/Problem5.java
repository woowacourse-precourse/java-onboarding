package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = withdrawMoney(money);
        return answer;
    }

    private static List<Integer> withdrawMoney(int money) {
        List<Integer> wallet = new ArrayList<>();
        List<Currency> currencies = List.of(Currency.values());
        for (Currency currency : currencies) {
            wallet.add(currency.countCurrencyAmount(money));
            money = currency.calculateBalance(money);
        }
        return wallet;
    }

    enum Currency {
        FIVE_MILLION_WON_BILL(50000), ONE_MILLION_WON_BILL(10000), FIVE_THOUSAND_WON_BILL(5000),
        ONE_THOUSAND_WON(1000), FIVE_HUNDRED_WON_COIN(500), ONE_HUNDRED_WON_COIN(100),
        FIFTY_WON_COIN(50), TEN_WON_COIN(10), ONE_WON_COIN(1);

        private final int unit;

        Currency(int unit) {
            this.unit = unit;
        }

        public int countCurrencyAmount(int money) {
            return money / this.unit;
        }

        public int calculateBalance(int money) {
            return money - unit * countCurrencyAmount(money);
        }
    }
}
