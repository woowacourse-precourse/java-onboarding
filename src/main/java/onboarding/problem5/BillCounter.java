package onboarding.problem5;

import java.util.ArrayList;
import java.util.List;

public class BillCounter {

    private int getCapableBillCount(int bill, int money) {
        return money / bill;
    }

    public List<Integer> getCapableBillsCount(WonBills wonbills, int money) {
        validateMoneyRange(money);

        List<Integer> counts = new ArrayList<>();

        for (int bill: wonbills.getBills()) {
            int count = getCapableBillCount(bill, money);
            money -= count * bill;

            counts.add(count);
        }

        return counts;
    }

    private void validateMoneyRange(int money) throws IllegalArgumentException {
        if (!(1 <= money && money <= 1_000_000)) {
            throw new IllegalArgumentException("money는 1이상 1,000,000이하여야 합니다.");
        }
    }
}
