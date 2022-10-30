package onboarding;

import onboarding.problem5.MoneyChanger;

import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        MoneyChanger moneyChanger = new MoneyChanger();

        return moneyChanger.change(money);
    }
}
