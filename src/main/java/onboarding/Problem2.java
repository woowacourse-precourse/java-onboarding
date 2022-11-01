package onboarding;

import java.util.*;

public class Problem2 {
    public static final char FIRST_CHARACTER = 'A';
    public static char previousChar;

    public static boolean isContinuous(char next) {
        return next == previousChar;
    }

    public static String remove(String cipher) {
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
        StringBuilder answer = new StringBuilder();
        stack.forEach(answer::append);
        return answer.toString();

    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        return remove(cryptogram);
    }
}