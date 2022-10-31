package problem5;

import java.util.ArrayList;
import java.util.List;

public class MoneyChanger {
    private static final int AMOUNT_LOWER_BOUNDS = 1;
    private static final int AMOUNT_UPPER_BOUNDS = 1_000_000;
    private static final String ERR_AMOUNT_RANGE = "돈의 양은 1 이상 1,000,000 이하여야 합니다.";
    private static final List<Integer> bills = new ArrayList<>();

    static {
        bills.add(50000);
        bills.add(10000);
        bills.add(5000);
        bills.add(1000);
        bills.add(500);
        bills.add(100);
        bills.add(50);
        bills.add(10);
        bills.add(1);
    }

    public static List<Integer> change(int money) {
        validateAmount(money);

        List<Integer> result = new ArrayList<>();

        for (Integer bill : bills) {
            result.add(money / bill);
            money %= bill;
        }

        return result;
    }

    private static void validateAmount(int money) {
        if (money < AMOUNT_LOWER_BOUNDS || money > AMOUNT_UPPER_BOUNDS)
            throw new IllegalArgumentException(ERR_AMOUNT_RANGE);
    }
}
