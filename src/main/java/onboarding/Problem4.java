package onboarding;

public class Problem4 {

  public static String solution(String word) {
    String answer = "";
    return answer;
  }

  public static char convertAlpha(char alpha) {

    if (alpha >= 65 && alpha <= 90) {
      int offset = 25 - (alpha - 'A') * 2;
      return (char) (alpha + offset);
    }
    if (alpha >= 97 && alpha <= 122) {
      int offset = 25 - (alpha - 'a') * 2;
      return (char) (alpha + offset);
    }
    return alpha;
  }
}
