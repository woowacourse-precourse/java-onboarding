package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {
  static class Decryption {
    private final Stack<Character> message = new Stack<>();
    private Character lastCode;

    public void decrypt(Character code) {
      if (!message.empty() && this.isSameCode(code)) {
        message.pop();
        lastCode = code;
        return;
      }
      if(this.isSameLastCode(code)) {
        return;
      }
      message.push(code);
      lastCode = null;
    }

    public boolean isSameLastCode(Character code) {
      return this.lastCode == code;
    }

    public String getMessage() {
      return message.stream()
              .map(Object::toString)
              .collect(Collectors.joining());
    }

    private boolean isSameCode(Character code) {
      return message.peek() == code;
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
