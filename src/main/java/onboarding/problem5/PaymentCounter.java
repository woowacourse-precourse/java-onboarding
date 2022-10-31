package onboarding.problem5;

import java.util.ArrayList;
import java.util.List;

public class PaymentCounter {

    private final int[] units;

    public PaymentCounter(int[] units) {
        this.units = units;
    }

    public List<Integer> count(int money) {
        List<Integer> counts = new ArrayList<>();
        for (int unit : units) {
            counts.add(money / unit);
            money %= unit;
        }
        return counts;
    }
}
