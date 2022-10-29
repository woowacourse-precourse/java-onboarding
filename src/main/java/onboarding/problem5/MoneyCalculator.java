package onboarding.problem5;

import java.util.ArrayList;
import java.util.List;

/**
 * Calculate count number of each money unit
 */
public class MoneyCalculator {

    private final int[] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    private int money;

    public MoneyCalculator(int money) {
        this.money = money;
    }

    public List<Integer> calculate() {
        List<Integer> counts = new ArrayList<>();
        for (int unit : units) {
            counts.add(money / unit);
            money %= unit;
        }
        return counts;
    }
}
