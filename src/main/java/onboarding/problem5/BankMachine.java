package onboarding.problem5;

import java.util.ArrayList;
import java.util.List;

import static onboarding.problem5.ConstantsP5.CURRENCY;

public class BankMachine {
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
