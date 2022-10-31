package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

  public static List<Integer> solution(int money) {
    List<Integer> answer = withDraw(money);
    return answer;
  }

  public static List<Integer> withDraw(int money){
    List<Integer> result = new ArrayList<>();
    int[] moneyUnits = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    for (int unit : moneyUnits) {
      int count = money / unit;
      money = money % unit;
      result.add(count);
    }
    return result;
  }
}
