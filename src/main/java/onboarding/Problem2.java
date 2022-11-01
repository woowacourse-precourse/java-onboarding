package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        return decrypt(cryptogram);
    }

    private static String decrypt(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        char before = ' ';

        for (int i = 0; i < cryptogram.length(); i++) {
            char c = cryptogram.charAt(i);
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
                before = c;
                continue;
            }
            if (c == before) {
                continue;
            }
            stack.push(c);
        }
        return changeStackToString(stack);
    }

    private static String changeStackToString(Stack<Character> stack) {
        return stack.stream().map(Object::toString).collect(Collectors.joining());
    }
}

