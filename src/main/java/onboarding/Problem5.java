package onboarding;

import java.util.List;
import onboarding.problem5.Account;

public class Problem5 {
    public static List<Integer> solution(int money) {
        Account account = new Account(money);
        return account.withdraw();
    }
}
