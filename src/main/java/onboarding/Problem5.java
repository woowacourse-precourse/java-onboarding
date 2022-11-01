package onboarding;

import java.util.*;
import onboarding.problem5.Bank;

public class Problem5 {

    public static List<Integer> solution(int money) {

        Bank bank = new Bank();
        bank.init();
        bank.exchangeMoney(money);

        return bank.getExchangeResult();
    }
}
