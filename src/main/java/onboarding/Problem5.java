package onboarding;

import onboarding.problem5.WonBills;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    public static int getCapableBillCount(int bill, int money) {
        return money / bill;
    }

    public static List<Integer> getCapableBillsCount(WonBills wonbills, int money) {
        ArrayList<Integer> counts = new ArrayList<>();

        for (int bill: wonbills.getBills()) {
            int count = getCapableBillCount(bill, money);
            money -= count * bill;

            counts.add(count);
        }

        return counts;
    }

    public static List<Integer> solution(int money) {
        return getCapableBillsCount(new WonBills(), money);
    }
}
