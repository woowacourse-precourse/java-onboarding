package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {

  public static String solution(String cryptogram) {
    Stack<Character> stack = new Stack<>();

    int index = 0;
    while (index < cryptogram.length()) {
      if (stack.isEmpty() || !stack.peek().equals(cryptogram.charAt(index))) {
        stack.push(cryptogram.charAt(index));
        ++index;
        continue;
      }
      while (index < cryptogram.length() && stack.peek().equals(cryptogram.charAt(index))) {
        ++index;
      }
      stack.pop();
    }

    return stack.stream().map(Object::toString).collect(Collectors.joining());
  }
}
