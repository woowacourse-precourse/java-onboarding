package onboarding;

import onboarding.problem5.BankAccount;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        BankAccount bankAccount = new BankAccount();
        List<Integer> answer = bankAccount.withdraw(money);
        return answer;
    }
}
