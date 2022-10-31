package onboarding;

public class Problem2 {

  public static String solution(String cryptogram) {
    String answer = cryptogram;
    int i = 0;
    while (i < answer.length() - 1) {
      if (answer.charAt(i) == answer.charAt(i + 1)) {
        answer = deleteCharAt(answer, i);
        if (i > 0) {
          i--;
        }
      } else {
        i++;
      }
    }
    return answer;
  }

  static String deleteCharAt(String str, int index) {
    return str.substring(0, index) + str.substring(index + 2, str.length());
  }
}
