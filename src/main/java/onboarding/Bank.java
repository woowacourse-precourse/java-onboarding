package onboarding;

import java.util.List;

public class Bank {
    private int money;

    public Bank(int money) {
        validMoney(money);

        this.money = money;
    }

    public List<Integer> exchangeToUnits() {
        MoneyExchanger moneyExchanger = new MoneyExchanger();

        return moneyExchanger.toUnits(money);
    }

    private void validMoney(int money) {
        if (money < 1 || money > 1000000)
            throw new IllegalArgumentException("money는 1 이상 1,000,000 이하여야 합니다.");
    }
}
