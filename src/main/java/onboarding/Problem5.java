package onboarding;

import onboarding.problem5.MoneyCounter;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        MoneyCounter moneyCounter = new MoneyCounter(money);
        return moneyCounter.count();
    }
}
