package onboarding;

public class Problem3 {

  public static int solution(int number) {
    int answer = 0;
    for (int i = 1; i <= number; i++) {
      answer += getNumberOf369(i);
    }
    return answer;
  }

  private static int getNumberOf369(int number) {
    int result = 0;
    while (number > 0) {
      if (number % 10 == 3 || number % 10 == 6 || number % 10 == 9) {
        result++;
      }
      number /= 10;
    }
    return result;
  }
}
