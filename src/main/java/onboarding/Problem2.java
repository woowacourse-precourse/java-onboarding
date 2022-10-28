package onboarding;

import java.util.Stack;

public class Problem2 {

  public static String solution(String cryptogram) {
    Stack<Character> s = new Stack<Character>();
    StringBuilder buf = new StringBuilder();
    for (int i = 0; i < cryptogram.length(); i++) {
      if (s.empty()) {
        s.push(cryptogram.charAt(i));
      } else if (s.peek() == cryptogram.charAt(i)) {
          s.pop();
      } else {
          s.push(cryptogram.charAt(i));
      }
    }
      while (!s.empty()) {
          buf.append(s.pop());
      }
    return buf.reverse().toString();
  }
}
