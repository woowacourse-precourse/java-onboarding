package onboarding.problem5;

import java.util.ArrayList;
import java.util.List;

public class Money {
    private int money;

    public Money(int money) {
        this.money = money;
    }

    public List<Integer> transformMoney() {
        List<Integer> result = new ArrayList<>(9);
        int number = money;
        Integer[] list = new Integer[] {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for (int i = 0; i < list.length; i++) {
            result.add((int) number / list[i]);
            number = number % list[i];
        }
        return result;
    }
}
