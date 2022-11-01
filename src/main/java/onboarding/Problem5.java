package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

  public static List<Integer> solution(int money) {
    List<Integer> answer = new ArrayList<>();
    int[] moneyList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    for (int unit : moneyList) {
      if (unit > money) {
        answer.add(0);
        continue;
      }
      answer.add(money / unit);
      money %= unit;
    }
    return answer;
  }
}
