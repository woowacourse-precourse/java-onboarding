package onboarding;

import java.util.*;

public class Problem2 {

  public static String solution(String cryptogram) {
    Deque<Character> cryptogramStack = convertStringToStack(cryptogram);
    Deque<Character> resultStack = eliminateDuplicatedChar(cryptogramStack);

    return "";
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
