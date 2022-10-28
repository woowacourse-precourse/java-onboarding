package onboarding;

import java.util.Arrays;

public class Problem3 {

  private static final int MAX_NUMBER = 10000;
  private static final int EXCEPTION_ANSWER = -1;

  public static int solution(int number) {
    if (isAllowedNumber(number)) {
      return clapCount(number);
    }
    return EXCEPTION_ANSWER;
  }

  public static int clapCount(int number) {
    int count = 0;
    for (int i = 1; i <= number; i++) {
      count += eachNumClapCount(i);
    }
    return count;
  }

  private static int eachNumClapCount(int number) {
    String[] splitNumber = String.valueOf(number).split("");
    long count = Arrays.stream(splitNumber)
        .filter(s -> s.equals("3") || s.equals("6") || s.equals("9"))
        .count();
    return Long.valueOf(count).intValue();
  }

  public static boolean isAllowedNumber(int number) throws IllegalStateException {
    if (number < 1 || number > MAX_NUMBER) {
      throw new IllegalStateException("1 ~ 10000 사이의 숫자가 아닙니다.");
    }
    return true;
  }

}
