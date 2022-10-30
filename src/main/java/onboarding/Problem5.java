package onboarding;

import onboarding.problem5.ATM;

import java.util.List;

public class Problem5 {
  public static List<Integer> solution(int money) {
    ATM atm = new ATM();
    return atm.withdraw(money);
  }
}
