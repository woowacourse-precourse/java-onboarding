package onboarding;

public class Problem3 {

  public static int countClap(int number) {
    int clap = 0;
    for (int i = 0; i <= number; i++) {
      String num = Integer.toString(i);
      for (int j = 0; j < num.length(); j++) {
          if (num.charAt(j) == '3' ||
              num.charAt(j) == '6' ||
              num.charAt(j) == '9') {
              clap++;
          }
      }
    }
    return clap;
  }

  public static int solution(int number) {
    return countClap(number);
  }
}