package onboarding;

public class Problem3 {

  public static int solution(int number) {
    int answer = 0;
    for (int i = 1; i <= number; i++) {
      answer += getCount369In(i);
    }
    return answer;
  }

  private static int getCount369In(int number) {
    int result = 0;
    while (number != 0) {
      int digit = number % 10;
      if (digit == 3 || digit == 6 || digit == 9) {
        result++;
      }
      number /= 10;
    }
    return result;
  }
}
