package onboarding;

public class Problem3 {
  public static int solution(int number) {
    int i=1, count=0;
      for (; i <= number; i++) {
          count+=countThreefold(i);
      }
    return count;
  }

  static int countThreefold(int num) {
    //System.out.print(num+":");
    int count=0;
    while (num != 0) {
        if (isThreefold(num % 10)) {
          count++;
        }
      num /= 10;
    }
    //System.out.println(count);
    return count;
  }

  static boolean isThreefold(int num) {
    switch (num) {
      case 3:
      case 6:
      case 9:
        return true;
      default:
        return false;
    }
  }
}
