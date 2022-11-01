package onboarding;

import problem5.Bank;

import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        Bank bank = new Bank();
        return bank.changeAllMoney(money);
    }
}
