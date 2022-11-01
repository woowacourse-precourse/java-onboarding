package onboarding.problem5;

import java.util.LinkedList;
import java.util.List;

public class Account {

    private final int MIN_MONEY = 1;
    private final int MAX_MONEY = 1_000_000;
    private final int[] UNIT = {50_000, 10_000, 5_000, 1_000, 500, 100, 50 , 10, 1};

    private int money;

    public Account(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if (isOutOfBounds(money)) throw new IllegalArgumentException("money is out of bounds");
    }

    private boolean isOutOfBounds(int money) {
        return money < MIN_MONEY || money > MAX_MONEY;
    }

    public List<Integer> withdraw() {

        List<Integer> list = new LinkedList<>();

        for (int unit : UNIT) {
            int count = money / unit;
            money -= unit * count;
            list.add(count);
        }

        return list;
    }
}
