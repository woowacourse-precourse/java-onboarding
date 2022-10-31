package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {
    public static final char FIRST_CHARACTER = 'A';
    public static char previousChar;

    public static boolean isContinuous(char next) {
        return next == previousChar;
    }

    public static String removeDuplication(String cipher) {
        Stack<Character> stack = new Stack<>();
        previousChar = FIRST_CHARACTER;

        for (char nextChar : cipher.toCharArray()) {
            if (isContinuous(nextChar))
                continue;

            if (stack.isEmpty() || stack.peek() != nextChar) {
                stack.add(nextChar);
                previousChar = FIRST_CHARACTER;
                continue;
            }

            previousChar = stack.pop();
        }

        return stack.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }

    public static String solution(String cryptogram) {
        return removeDuplication(cryptogram);
    }
}
