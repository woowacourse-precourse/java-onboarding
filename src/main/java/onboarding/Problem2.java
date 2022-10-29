package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {

  public static String solution(String cryptogram) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < cryptogram.length(); i++) {
      char currChar = cryptogram.charAt(i);
      if (stack.isEmpty() || stack.peek() != currChar) {
        stack.push(currChar);
      } else {
        stack.pop();
        while (i + 1 < cryptogram.length() && currChar == cryptogram.charAt(i + 1)) {
          i++;
        }
      }
    }
    return stack.stream()
        .map(Object::toString)
        .collect(Collectors.joining());
  }
}
