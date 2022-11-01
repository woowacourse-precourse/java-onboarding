package onboarding;

import java.util.Stack;
import java.util.regex.Pattern;

public class Problem2 {

  public static String solution(String cryptogram) {
    return new FindDuplicatePro2(cryptogram).stackToStringReverse();
  }
}
