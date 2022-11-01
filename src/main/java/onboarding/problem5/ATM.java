package onboarding.problem5;

import java.util.ArrayList;
import java.util.List;

public class ATM {
  private static final List<Integer> units = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

  public List<Integer> withdraw(int money) {
    List<Integer> result = new ArrayList<>();
    for (Integer unit : units) {
      result.add(money / unit);
      money %= unit;
    }
    return result;
  }
}