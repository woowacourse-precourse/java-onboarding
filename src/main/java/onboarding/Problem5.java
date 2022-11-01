package onboarding;

import onboarding.problem5.BillCounter;
import onboarding.problem5.WonBills;

import java.util.List;

public class Problem5 {

    public static List<Integer> solution(int money) {
        BillCounter billCounter = new BillCounter();

        return billCounter.getCapableBillsCount(new WonBills(), money);
    }
}
