package onboarding;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {
  static class Decryption {
    private final Stack<Character> message = new Stack<>();

    public void decrypt(Character c) {
      if (!message.empty() && this.isSameCharacter(c)) {
        message.pop();
        return;
      }
      message.push(c);
    }

    public String getMessage() {
      return message.stream()
              .map(Object::toString)
              .collect(Collectors.joining());
    }

    private boolean isSameCharacter(Character c) {
      return message.peek() == c;
    }
  }

  public static String solution(String cryptogram) {
    Decryption decryption = new Decryption();
    for (char code : cryptogram.toCharArray()) {
      decryption.decrypt(code);
    }
    return decryption.getMessage();
  }
}
