package onboarding;

import java.util.List;

import onboarding.billcounter.BillCounter;

public class Problem5 {
    public static List<Integer> solution(int money) {
        BillCounter counter = new BillCounter(money);
        return counter.getBills();
    }
}
