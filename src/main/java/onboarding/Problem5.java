package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class CurrencyForPro5 {

  private static final int[] CURRENCY = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
  private static final int MONEY_FIRST = 1;
  private static final int MONEY_LAST = 1000000;

  public CurrencyForPro5(int money) {
    validateMoney(money);
  }

  public void validateMoney(int money) {
    if (MONEY_FIRST > money || money > MONEY_LAST) {
      throw new IllegalArgumentException(
          "money는 " + MONEY_FIRST + "이상 " + MONEY_LAST + "이하의 정수여야 합니다.");
    }
  }

  public List<Integer> countUses(int money) {
    List<Integer> countCur = new ArrayList<>();
    for (int curr : CURRENCY) {
      countCur.add(money / curr);
      money %= curr;
    }
    return countCur;
  }
}

public class Problem5 {

  public static List<Integer> solution(int money) {
    CurrencyForPro5 currencyClass = new CurrencyForPro5(money);
    return currencyClass.countUses(money);
  }
}
