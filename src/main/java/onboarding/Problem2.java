package onboarding;

public class Problem2 {

  public static String solution(String cryptogram) {
    String answer = "answer";
    return answer;
  }

  public static boolean isAllowedString(String cryptogram) throws IllegalStateException {
    for (int i = 0; i < cryptogram.length(); i++) {
      int temp = cryptogram.charAt(i) - 0;
      if (temp < 97 || temp > 122) {
        throw new IllegalStateException("소문자 알파벳으로 이루어진 문자열이 아닙니다.");
      }
    }
    return true;
  }
}
