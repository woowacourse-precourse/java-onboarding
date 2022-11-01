package onboarding;

import java.util.*;

public class Problem2 {

  public static String solution(String cryptogram) {
    validate(cryptogram);
    Deque<Character> cryptogramStack = convertStringToStack(cryptogram);
    Deque<Character> resultStack = eliminateDuplicatedChar(cryptogramStack);
    return convertStackToString(resultStack);
  }

  public static void validate(String string) {
    /*
     정상적인 문자열이 입력되지 않은 경우 - 문제에서 요구하는 별도의 요구사항이 없음으로 예외 발생
     1. 문자열 길이가 제한 사항에 속하지 않은 경우 (1이상 1000이하)
     2. 알파벳 소문자로 구성하지 않은 경우
    */
    isInRange(string);
    isStringConsistOfLowerCase(string);
  }

  public static void isInRange(String string) {
    if (string.length() < 1 || string.length() > 1000) {
      throw new IllegalArgumentException("범위 초과");
    }
  }

  public static void isStringConsistOfLowerCase(String string) {
    for (char i : string.toCharArray()) {
      if (!Character.isLowerCase(i)) {
        throw new IllegalArgumentException("소문자로만 구성이 되어야합니다.");
      }
    }
  }

  public static String convertStackToString(Deque<Character> stack) {
    StringBuilder stringBuilder = new StringBuilder();
    while (!stack.isEmpty()) {
      stringBuilder.append(stack.peekLast());
      stack.removeLast();
    }
    return stringBuilder.toString();
  }

  public static Deque<Character> eliminateDuplicatedChar(Deque<Character> originalStack) {
    Deque<Character> resultStack = new ArrayDeque<>();
    while (!originalStack.isEmpty()) {
      Character pop = originalStack.getLast();
      originalStack.removeLast();
      // stack이 비어 있지 않고 & 이전에 pop한 값과 새로 pop한 값이 같으면 -> 중복된 값이 있으므로 resultStack에 추가 하지 않는다.
      if (!resultStack.isEmpty() && Objects.equals(pop, resultStack.peekLast())) {
        resultStack.removeLast();
        continue;
      }
      // stack이 비어있거나 중복된 문자가 아닐경우 resultStack 추가한다.
      resultStack.addLast(pop);
    }
    return resultStack;
  }

  public static Deque<Character> convertStringToStack(String string) {
    Deque<Character> stack = new ArrayDeque<>();
    for (char letter : string.toCharArray()) {
      stack.add(letter);
    }
    return stack;
  }
}
