package onboarding;

public class Problem3 {

  private static final int MAX_NUMBER = 10000;

  public static int solution(int number) {
    int answer = 0;
    return answer;
  }

  public static boolean isAllowedNumber(int number) throws IllegalStateException {
    if (number < 1 || number > MAX_NUMBER) {
      throw  new IllegalStateException("1 ~ 10000 사이의 숫자가 아닙니다.");
    }
    return true;
  }

}
