package onboarding.problem5;

import java.util.ArrayList;
import java.util.List;

public class BillCounter {

    public int getCapableBillCount(int bill, int money) {
        return money / bill;
    }

    public List<Integer> getCapableBillsCount(WonBills wonbills, int money) {
        List<Integer> counts = new ArrayList<>();

        for (int bill: wonbills.getBills()) {
            int count = getCapableBillCount(bill, money);
            money -= count * bill;

            counts.add(count);
        }

        return counts;
    }
}
