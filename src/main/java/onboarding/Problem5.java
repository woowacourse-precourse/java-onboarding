package onboarding;

import onboarding.problem5.Account;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        Account account = new Account(money);
        return account.withdraw();
    }
}
