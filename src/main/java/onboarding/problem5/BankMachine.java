package onboarding.problem5;

import java.util.ArrayList;
import java.util.List;

public class BankMachine {
    private static final List<Integer> CURRENCY = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
    private final Money money;

    public BankMachine(Money money) {
        this.money = money;
    }

    public CurrencyDto convertMoneyToCurrency() {
        List<Integer> currencyList = new ArrayList<>();
        int amount = money.getAmount();

        for (int moneys : CURRENCY) {
            currencyList.add(amount / moneys);
            amount %= moneys;
        }
        return new CurrencyDto(currencyList);
    }
}
