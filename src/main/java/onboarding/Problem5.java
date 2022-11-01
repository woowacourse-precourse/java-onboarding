package onboarding;

import onboarding.problem5.Cash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return countCash(money);
    }

    public static List<Integer> countCash(int money) {
        List<Integer> cashCount = new ArrayList<>();
        for (Cash cash : Cash.values()) {
            cashCount.add(money / cash.getPrice());
            money %= cash.getPrice();
        }
        return cashCount;
    }
}
