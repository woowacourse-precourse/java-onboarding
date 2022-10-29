package onboarding;

import java.util.Stack;

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

  public void validateCryptogram(String cryptogram) {
    if (!cryptogram.equals(cryptogram.toLowerCase())) {
      throw new IllegalArgumentException("A cryptogram should be a string of lowercase.");
    }
    if (cryptogram.length() < MIN_WORD_LENGTH || cryptogram.length() > MAX_WORD_LENGTH) {
      throw new IllegalArgumentException("A cryptogram should be a string of length between "
          + MIN_WORD_LENGTH + " and " + MAX_WORD_LENGTH + ".");
    }
  }

  public Stack<Character> eraseDuplicate() {
    Stack<Character> s = new Stack<>();
    String cryptogram = this.cryptogram;
    for (int i = 0; i < cryptogram.length(); i++) {
      if (s.empty()) {
        s.push(cryptogram.charAt(i));
      } else if (s.peek() == cryptogram.charAt(i)) {
        s.pop();
      } else {
        s.push(cryptogram.charAt(i));
      }
    }
    return s;
  }

  public String stackToStringReverse() {
    StringBuilder buf = new StringBuilder();
    Stack<Character> s = this.originalWord;
    while (!s.empty()) {
      buf.append(s.pop());
    }
    return buf.reverse().toString();
  }
}

public class Problem2 {

  public static String solution(String cryptogram) {
    FindDuplicatePro2 finder = new FindDuplicatePro2(cryptogram);
    return finder.stackToStringReverse();
  }
}
