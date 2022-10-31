package onboarding;

import onboarding.problem5.MoneyChanger;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        MoneyChanger changer = new MoneyChanger();
        return changer.getChanges(money);
    }
}
