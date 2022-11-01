package onboarding.problem02.infra.util;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Decryptor {

  public static String processing(String str) {
    Stack<Character> result = new Stack<>();
    char[] chars = str.toCharArray();
    for (char charIndex : chars) {
      if (result.isEmpty()) {
        result.push(charIndex);
      } else {
        if (charIndex == result.peek()) {
          result.pop();
        } else {
          result.push(charIndex);
        }
      }
    }
    return result.stream().map(index -> index.toString()).collect(Collectors.joining(""));
  }
}
