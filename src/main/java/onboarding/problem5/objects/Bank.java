package onboarding.problem5.objects;

import java.util.List;

public class Bank {

    private Money money;

    public Bank(Money money) {
        this.money = money;
    }

    public List<Integer> withdraw() {
        return this.money.getMoneyUnitCounter()
                .getUnitCounts(money.getMoney());
    }
}
