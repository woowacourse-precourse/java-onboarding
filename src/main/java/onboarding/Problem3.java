package onboarding;

public class Problem3 {

  public static int solution(int number) {
    int answer = 0;
    while (number > 0) {
      answer += calculateClapCount(number);
      number--;
    }
    return answer;
  }

  public static int calculateClapCount(int number) {
    int count = 0;

    while (number > 0) {
      int temp = number % 10;
      if (temp == 3 || temp == 6 || temp == 9) {
        count++;
      }
      number /= 10;
    }
    return count;
  }
}
