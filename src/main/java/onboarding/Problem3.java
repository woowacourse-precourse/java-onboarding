package onboarding;

public class Problem3 {

  public static int solution(int number) {
    int clap = 0;
    for (int presentNumber = 1; presentNumber < number + 1; presentNumber++) {
      clap += countClap(presentNumber);
    }
    return clap;
  }

  private static int countClap(int presentNumber) {
    int count = 0;
    while (presentNumber > 0) {
      int digit = presentNumber % 10;
      count += check369(digit);
      presentNumber /= 10;
    }
    return count;
  }

  private static int check369(int digit) {
    if (digit == 3 || digit == 6 || digit == 9) {
      return 1;
    }
    return 0;
  }
}
