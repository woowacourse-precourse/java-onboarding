package onboarding;

import onboarding.problem5.Bank;
import onboarding.problem5.MoneyUnit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return new Bank(MoneyUnit.KOREA).withdraw(money);
    }
}
