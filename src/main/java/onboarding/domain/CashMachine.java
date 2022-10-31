package onboarding.domain;

import java.util.ArrayList;
import java.util.List;

public class CashMachine {
    private static final List<Integer> UNIT_OF_CHANGE = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    private final List<Integer> withdrawResult;

    public CashMachine(int money) {
        this.withdrawResult = changeMoney(money);
    }

    private List<Integer> changeMoney(int money) {
        List<Integer> withdrawResult = new ArrayList<>();
        for (int change : UNIT_OF_CHANGE) {
            withdrawResult.add(money / change);
            money %= change;
        }
        return withdrawResult;
    }

    public List<Integer> withdrawMoney() {
        return withdrawResult;
    }
}
