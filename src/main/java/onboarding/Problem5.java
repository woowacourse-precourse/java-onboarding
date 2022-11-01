package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
  private static final int[] CHANGE_LIST = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
  private static final int MIN_RANGE_NUMBER = 1;
  private static final int MAX_RANGE_NUMBER = 1000000;

  public static List<Integer> solution(int money) {
    validate(money);
    return solveChangeList(money);
  }

  private static List<Integer> solveChangeList(int money) {
    List<Integer> answer = new ArrayList<>(10);
    for (int change : CHANGE_LIST) {
      answer.add(money / change);
      money %= change;
    }
    return answer;
  }

  public static void validate(int number) {
    if (isInRange(number)) {
      throw new IllegalArgumentException("범위 초과");
    }
  }

  private static boolean isInRange(int number) {
    return (number < MIN_RANGE_NUMBER) || (MAX_RANGE_NUMBER < number);
  }
}