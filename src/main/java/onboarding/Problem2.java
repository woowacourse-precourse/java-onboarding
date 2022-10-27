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

  public static boolean isAllowedStringLength(String cryptogram) throws IllegalStateException {
    if (cryptogram.length() < 1 || cryptogram.length() > 10) {
      throw new IllegalStateException("1 ~ 4000자 길이의 문자열이 아닙니다.");
    }
    return true;
  }
}
