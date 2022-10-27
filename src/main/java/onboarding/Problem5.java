package onboarding;

import java.util.List;

public class Problem5 {
  static class ATM {

    public List<Integer> withdraw(int money) {
      return List.of(1);
    }
  }

  public static List<Integer> solution(int money) {
    ATM atm = new ATM();
    return atm.withdraw(money);
  }
}
