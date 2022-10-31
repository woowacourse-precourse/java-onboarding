package onboarding;

import onboarding.domain.CashMachine;

import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        CashMachine cashMachine = new CashMachine(money);
        return cashMachine.withdrawMoney();
    }
}
