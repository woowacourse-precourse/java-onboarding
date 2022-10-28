package onboarding;

public class Problem4 {

  public static char reverseAlpha(char c) {
    int move = 0;
    if (c >= 'A' && c <= 'M') {
      move = 'M' + 'N' - c;
    } else if (c >= 'N' && c <= 'Z') {
      move = 'M' + 'N' - c;
    } else if (c >= 'a' && c <= 'm') {
      move = 'm' + 'n' - c;
    } else if (c >= 'n' && c <= 'z') {
      move = 'm' + 'n' - c;
    }
    return (char) move;
  }

  public static String solution(String word) {
    StringBuilder buf = new StringBuilder();
    for (int i = 0; i < word.length(); i++) {
        if (word.charAt(i) == ' ') {
            buf.append(word.charAt(i));
        } else {
            buf.append(reverseAlpha(word.charAt(i)));
        }
    }
    return buf.toString();
  }
}
