package problem5;

import java.util.Arrays;
import java.util.List;

public class AccountWithDraw {
    private int money;
    private final List<Integer> unit = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    public AccountWithDraw(int money) {
        this.money = money;
    }

    public List<Integer> withDraw() {
        List<Integer> result = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0);
        int index = 0;

        while(money != 0) {
            int count = getCount(index);
            result.set(index, count);
            index += 1;
        }
        return result;
    }

    private int getCount(int index) {
        int count = money / unit.get(index);
        money = money % unit.get(index);
        return count;
    }
}
