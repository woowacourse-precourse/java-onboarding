package onboarding;

import java.util.Stack;

class Stack2 {

  private static final int MINIMUM_LENGTH = 1;
  private static final int MAXIMUM_LENGTH = 1000;

  public Stack2(String cryptogram) {
    validateCrypto(cryptogram);
  }

  public Stack<Character> pushAndPop(Stack<Character> stack, String cryptogram) {
    char[] array = cryptogram.toCharArray();
    char tmp = 0;
    stack.push(array[0]);

    for (int i = 1; i < array.length; i++) {
      if (array[i] == tmp) {
        continue;
      }
      if (stack.isEmpty()) {
        stack.push(array[i]);
      } else if (stack.peek() == array[i]) {
        tmp = stack.pop();
        stack.trimToSize();
      } else if (stack.peek() != array[i]) {
        stack.push(array[i]);
        tmp = 0;
      }
    }
    return stack;
  }

  private void validateCrypto(String crypto) {
    validateLength(crypto);
    validateSmallAlpha(crypto);
  }

  private void validateLength(String crypto) {
    if (crypto.length() < MINIMUM_LENGTH || crypto.length() > MAXIMUM_LENGTH) {
      throw new IllegalArgumentException(
          "입력한 cryptogram의 길이는 " + MINIMUM_LENGTH + "이상 " + MAXIMUM_LENGTH + "이하여야 합니다.");
    }
  }

  private void validateSmallAlpha(String crypto) {
    if (!crypto.matches("^[a-z]*$")) {
      throw new IllegalArgumentException("cryptogram은 알파벳 소문자로만 입력해야 합니다.");
    }
  }
}

public class Problem2 {

  public static String solution(String cryptogram) {
    Stack2 stackClass = new Stack2(cryptogram);
    return stackToString(stackClass.pushAndPop(new Stack<>(), cryptogram), new StringBuilder());
  }

  public static String stackToString(Stack<Character> stack, StringBuilder sb) {
    if (stack.isEmpty()) {
      return "";
    }
    int size = stack.size();
    for (int i = 0; i < size; i++) {
      sb.append(stack.pop());
      stack.trimToSize();
    }
    sb.reverse();
    return sb.toString();
  }
}
