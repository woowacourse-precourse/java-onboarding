package onboarding;

import java.util.Stack;
import java.util.regex.Pattern;

class Crypto {

  private String cryptogram;

  Crypto(String cryptogram) {
    this.cryptogram = cryptogram;
  }

  private Stack<Character> stackMaker(Stack<Character> stack) {
    char prevPopValue = 0;
    for (int i = 0; i < cryptogram.length(); i++) {
      if (stack.empty()) {
        if (prevPopValue == cryptogram.charAt(i)) {
          continue;
        }
        stack.push(cryptogram.charAt(i));
        prevPopValue = 0;
        continue;
      }
      if (stack.peek() == cryptogram.charAt(i)) {
        prevPopValue = stack.pop();
        stack.trimToSize();
      } else if (stack.peek() != cryptogram.charAt(i)) {
        if (prevPopValue == cryptogram.charAt(i)) {
          continue;
        }
        stack.push(cryptogram.charAt(i));
        prevPopValue = 0;
      }
    }
    return stack;
  }

  public String makeAnswer() {
    Stack<Character> stack = stackMaker(new Stack<>());
    StringBuilder sb = new StringBuilder();
    int size = stack.size();
    for (int i = 0; i < size; i++) {
      char chunk = stack.pop();
      sb.append(chunk);
    }
    sb.reverse();
    return sb.toString();
  }
}

class ValidityCheckerProb2 {

  private static final int MINLIMIT = 1;
  private static final int MAXLIMIT = 1000;
  private static String cryptogram = null;

  ValidityCheckerProb2(String cryptogram) {
    this.cryptogram = cryptogram;
  }

  public void checkAllValidity() {
    lengthValidityCheck(cryptogram);
    allAlphaValidityCheck(cryptogram);
    lowercaseValidityCheck(cryptogram);
  }

  private void lengthValidityCheck(String cryptogram) {
    if (cryptogram.length() < MINLIMIT || cryptogram.length() > MAXLIMIT) {
      throw new IllegalArgumentException("cryptogram's length is off the limit.");
    }
  }

  private void allAlphaValidityCheck(String cryptogram) {
    if (!Pattern.matches("^[a-zA-Z]*$", cryptogram)) {
      throw new IllegalArgumentException("cryptogram contains more than alphabets.");
    }
  }

  private void lowercaseValidityCheck(String cryptogram) {
    if (!cryptogram.equals(cryptogram.toLowerCase())) {
      throw new IllegalArgumentException("cryptogram contains Upperclass alphabets.");
    }
  }
}

public class Problem2 {

  public static String solution(String cryptogram) {
    ValidityCheckerProb2 validitycheck = new ValidityCheckerProb2(cryptogram);
    validitycheck.checkAllValidity();
    Crypto cryptoClass = new Crypto(cryptogram);
    return cryptoClass.makeAnswer();
  }
}
