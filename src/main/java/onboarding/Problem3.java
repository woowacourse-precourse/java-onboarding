package onboarding;

public class Problem3 {
  public static int solution(int number) {
    validate(number);
    return getTotalClap(number);
  }

  private static void validate(int number) {
    if ((number < 1) || (number > 10000)) {
      throw new IllegalArgumentException("범위 초과");
    }
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
      if (is369Number(digitNumber)) {
        count++;
      }
      number /= 10;
    }
    return count;
  }

  private static boolean is369Number(int digitNumber) {
    return (digitNumber == 3) || (digitNumber == 6) || (digitNumber == 9);
  }
}
