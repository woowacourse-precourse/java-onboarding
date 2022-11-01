package onboarding;

import onboarding.problem5.BankMachine;
import onboarding.problem5.CurrencyDto;
import onboarding.problem5.Money;

import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        Money amount = new Money(money);
        CurrencyDto currencyList = new BankMachine(amount).convertMoneyToCurrency();
        return currencyList.toList();
    }
}
