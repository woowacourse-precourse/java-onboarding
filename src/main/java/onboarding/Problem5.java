package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem5 {

  private static final Integer[] monetaryUnit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

  static {
    Arrays.sort(monetaryUnit, Collections.reverseOrder());
  }

  public static List<Integer> solution(int money) {
    List<Integer> answer = new ArrayList<>();
    for (int unit : monetaryUnit) {
      answer.add(money / unit);
      money %= unit;
    }
    return answer;
  }
}
