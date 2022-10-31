package problem5;

import java.util.Arrays;
import java.util.List;

public class AccountWithDraw {
    private int money;
    private final List<Integer> unit = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    public AccountWithDraw(int money) {
        this.money = money;
    }

    private int getCount(int index) {
        int count = money / unit.get(index);
        money = money % unit.get(index);
        return count;
    }
}
