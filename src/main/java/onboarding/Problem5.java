package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

  private static int[] moneyTypeList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

  public static List<Integer> solution(int money) {
    List<Integer> answer = countEachTypeOfMoney(money);
    return answer;
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

}
