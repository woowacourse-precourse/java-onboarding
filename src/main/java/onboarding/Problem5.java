package onboarding;

import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        Bank bank = new Bank(money);

        return bank.exchangeToUnits();
    }
}
