package onboarding;

import java.util.List;

public class Bank {
    private int money;

    public Bank(int money) {
        this.money = money;
    }

    public List<Integer> exchangeToUnits() {
        MoneyExchanger moneyExchanger = new MoneyExchanger();

        return moneyExchanger.toUnits(money);
    }
}
