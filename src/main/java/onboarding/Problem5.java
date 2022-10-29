package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5 {

  private static int[] moneyTypeList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
  private static final int MAX_MONEY_SIZE = 1_000_000;
  private static final Integer[] EXCEPTION_LIST = {-99999};


  public static List<Integer> solution(int money) {
    if (isAllowedMoney(money)) {
      return countEachTypeOfMoney(money);
    }
    List<Integer> returnList = new ArrayList<>(Arrays.asList(EXCEPTION_LIST));
    return returnList;
  }

  public static List<Integer> countEachTypeOfMoney(int money) {
    List<Integer> eachMoneyCountList = new ArrayList<>();
    for (int moneyType : moneyTypeList) {
      if (money / moneyType != 0) {
        eachMoneyCountList.add(money / moneyType);
        money = money % moneyType;
      } else {
        eachMoneyCountList.add(0);
      }
    }
    return eachMoneyCountList;
  }

  public static boolean isAllowedMoney(int money) {
    if (money < 1 || money > MAX_MONEY_SIZE) {
      throw new IllegalStateException("허용된 금액이 아닙니다.");
    }
    return true;
  }

}
