package onboarding;

import onboarding.problem5.MoneyChanger;

import java.util.*;

public class Problem5 {
    public static List<Integer> solution(int money) {
        MoneyChanger moneyChanger = new MoneyChanger();
        moneyChanger.changeMoney(money);
        return moneyChanger.getChangedList();
    }
}
