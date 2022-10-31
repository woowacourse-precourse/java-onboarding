package onboarding;

import java.util.Stack;
import java.util.regex.Pattern;

class Crypto {

  private String cryptogram;

  Crypto(String cryptogram) {
    ValidityCheckerProb2 validitycheck = new ValidityCheckerProb2(cryptogram);
    validitycheck = null;
    this.cryptogram = cryptogram;
  }

  private Stack<Character> stackMaker(Stack<Character> stack) {
    char tmp = 0;
    for (int i = 0; i < cryptogram.length(); i++) {
      if (stack.empty()) {
        if (tmp == cryptogram.charAt(i)) {
          continue;
        }
        stack.push(cryptogram.charAt(i));
        continue;
      }
      if (stack.peek() == cryptogram.charAt(i)) {
        tmp = stack.pop();
      } else if (stack.peek() != cryptogram.charAt(i)) {
        if (tmp == cryptogram.charAt(i)) {
          continue;
        }
        stack.push(cryptogram.charAt(i));
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

  ValidityCheckerProb2(String cryptogram) {
    lengthValidityCheck(cryptogram);
    allAlphaValidityCheck(cryptogram);
    lowercaseValidityCheck(cryptogram);
  }

  private void lengthValidityCheck(String cryptogram) {
    if (cryptogram.length() < MINLIMIT || cryptogram.length() > MAXLIMIT) {
      throw new IllegalArgumentException("암호문의 길이가 범위 밖입니다.");
    }
  }

  private void allAlphaValidityCheck(String cryptogram) {
    if (!Pattern.matches("^[a-zA-Z]*$", cryptogram)) {
      throw new IllegalArgumentException("암호문에 영어가 아닌 문자가 있습니다.");
    }
  }

  private void lowercaseValidityCheck(String cryptogram) {
    if (!cryptogram.equals(cryptogram.toLowerCase())) {
      throw new IllegalArgumentException("암호문에 영어 소문자가 아닌 문자가 있습니다.");
    }
  }
}

public class Problem2 {

  public static String solution(String cryptogram) {
    Crypto cryptoClass = new Crypto(cryptogram);
    return cryptoClass.makeAnswer();
  }
}
