package onboarding;

import java.util.Stack;
import java.util.regex.Pattern;

class FindDuplicatePro2 {

  public final static int MIN_WORD_LENGTH = 1;
  public final static int MAX_WORD_LENGTH = 1000;
  private final String cryptogram;
  private final Stack<Character> originalWord;

  public FindDuplicatePro2(String cryptogram) {
    validateCryptogram(cryptogram);
    this.cryptogram = cryptogram;
    originalWord = eraseDuplicate();
  }

  public static boolean isAlpha(String str) {
    return Pattern.matches("^[a-zA-Z]*$", str);
  }

  public void validateCryptogram(String cryptogram) {
    if (!isAlpha(cryptogram)) {
      throw new IllegalArgumentException("The cryptogram should be given by alphabet.");
    }
    if (!cryptogram.equals(cryptogram.toLowerCase())) {
      throw new IllegalArgumentException("A cryptogram should be a string of lowercase.");
    }
    if (cryptogram.length() < MIN_WORD_LENGTH || cryptogram.length() > MAX_WORD_LENGTH) {
      throw new IllegalArgumentException("A cryptogram should be a string of length between "
          + MIN_WORD_LENGTH + " and " + MAX_WORD_LENGTH + ".");
    }
  }

  public Stack<Character> eraseDuplicate() {
    Stack<Character> stack = new Stack<>();
    Character tmp = 0;
    String cryptogram = this.cryptogram;
    for (int i = 0; i < cryptogram.length(); i++) {
      if (stack.empty()) {
        stack.push(cryptogram.charAt(i));
      } else if (stack.peek() == cryptogram.charAt(i)) {
        tmp = stack.pop();
      } else if (tmp != cryptogram.charAt(i)) {
        stack.push(cryptogram.charAt(i));
      }
    }
    return stack;
  }

  public String stackToStringReverse() {
    StringBuilder buf = new StringBuilder();
    Stack<Character> stack = this.originalWord;
    while (!stack.empty()) {
      buf.append(stack.pop());
    }
    return buf.reverse().toString();
  }
}

public class Problem2 {

  public static String solution(String cryptogram) {
    return new FindDuplicatePro2(cryptogram).stackToStringReverse();
  }
}
