package onboarding;

import onboarding.problem5.Bank;
import onboarding.problem5.BanknoteUnit;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        Bank bank = new Bank();
        List<Integer> result = bank.withdraw(money);

        return result;
    }
}
