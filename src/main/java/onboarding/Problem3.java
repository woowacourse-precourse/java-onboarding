package onboarding;

public class Problem3 {
  public static int solution(int number) {
    return getTotalClap(number);
  }
  private static int getTotalClap(int number) {
    int count = 0;
    for (int i = 1; i <= number; i++) {
      count += getClapCount(i);
    }
    return count;
  }
  private static int getClapCount(int number) {
    int count = 0;
    while (number > 0) {
      int digitNumber = number % 10;
      if ((digitNumber == 3) || (digitNumber == 6) || (digitNumber == 9)) {
        count++;
      }
      number /= 10;
    }
    return count;
  }
}
