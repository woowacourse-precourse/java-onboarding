package onboarding;

import java.util.*;

public class Problem2 {

  public static String solution(String cryptogram) {
    Deque<Character> cryptogramStack = convertStringToStack(cryptogram);

    return "";
  }

  public static Deque<Character> convertStringToStack(String string) {
    Deque<Character> stack = new ArrayDeque<>();
    for (char letter : string.toCharArray()) {
      stack.add(letter);
    }
    return stack;
  }
}
