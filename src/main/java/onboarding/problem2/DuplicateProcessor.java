package onboarding.problem2;

import java.util.ArrayDeque;
import java.util.Deque;

public class DuplicateProcessor {

    private final Deque<Character> stack = new ArrayDeque<>();

    public String checkDuplication(char[] cryptoCharArr) {
        for (char cryptoChar : cryptoCharArr) {
            if (stack.isEmpty()) {
                stack.addLast(cryptoChar);
                continue;
            }

            if (stack.peekLast() == cryptoChar) {
                stack.removeLast();
                continue;
            }

            stack.addLast(cryptoChar);
        }

        return getDecryptedString(stack);
    }

    private String getDecryptedString(Deque<Character> stack) {
        StringBuilder stringBuilder = new StringBuilder();

        while (!stack.isEmpty()) {
            stringBuilder.append(stack.removeFirst());
        }

        return stringBuilder.toString();
    }
}
