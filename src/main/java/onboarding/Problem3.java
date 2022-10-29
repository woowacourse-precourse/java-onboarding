package onboarding;

class CountClapPro3 {

  public final static int MIN_NUMBER = 1;
  public final static int MAX_NUMBER = 10_000;
  private final int number;

  public CountClapPro3(int number) {
    validateNumber(number);
    this.number = number;
  }

  public static void validateNumber(int number) {
    if (number < MIN_NUMBER || number > MAX_NUMBER) {
      throw new IllegalArgumentException("Number should be natural number between "
          + MIN_NUMBER + " and " + MAX_NUMBER + ".");
    }
  }

  public static boolean isThreeSixNine(Character c) {
    return c == '3' || c == '6' || c == '9';
  }

  public int countClap() {
    int clap = 0;
    for (int i = 0; i <= number; i++) {
      String num = Integer.toString(i);
      for (int j = 0; j < num.length(); j++) {
        if (isThreeSixNine(num.charAt(j))) {
          clap++;
        }
      }
    }
    return clap;
  }
}

public class Problem3 {

  public static int solution(int number) {
    CountClapPro3 count = new CountClapPro3(number);
    return count.countClap();
  }
}