package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {
  static class Decryption {
    private final Stack<Character> message = new Stack<>();
    private Character duplicateCode;

    public void decrypt(Character code) {
      if (isDuplicateCode(code)) {
        message.pop();
        saveDuplicateCode(code);
        return;
      }
      if (isSameAsDuplicateCode(code)) {
        return;
      }
      message.push(code);
      initializeDuplicateCode();
    }

    private void saveDuplicateCode(Character code) {
      duplicateCode = code;
    }

    private void initializeDuplicateCode() {
      duplicateCode = null;
    }

    private boolean isSameAsDuplicateCode(Character code) {
      return this.duplicateCode == code;
    }


    private boolean isDuplicateCode(Character code) {
      return !message.empty() && message.peek() == code;
    }

    public String getMessage() {
      return message.stream()
              .map(Object::toString)
              .collect(Collectors.joining());
    }
  }

  public static String solution(String cryptogram) {
    Decryption decryption = new Decryption();
    cryptogram.chars()
            .mapToObj(code -> (char) code)
            .forEach(code -> decryption.decrypt(code));
    return decryption.getMessage();
  }
}
