package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {

  public static String solution(String cryptogram) {
    Stack<Character> stack = new Stack<>();
    char curr;
    for (int i = 0; i < cryptogram.length(); i++) {
      curr = cryptogram.charAt(i);
      if (stack.isEmpty() || stack.peek() != curr) {
        stack.push(curr);
      } else {
        stack.pop();
        while (i + 1 < cryptogram.length() && curr == cryptogram.charAt(i + 1)) {
          i++;
        }
      }
    }

    return stack.stream()
        .map(String::valueOf)
        .collect(Collectors.joining());
  }
}
