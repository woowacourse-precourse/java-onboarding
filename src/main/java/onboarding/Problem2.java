package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < cryptogram.length(); i++) {
            if (!stack.empty() && stack.peek() == cryptogram.charAt(i)) {
                while (i < cryptogram.length() - 1 && stack.peek() == cryptogram.charAt(i + 1)) {
                    i++;
                }
                stack.pop();
                continue;
            }

            stack.push(cryptogram.charAt(i));
        }

        return stackDataToString(stack);
    }

    private static String stackDataToString(Stack<Character> stack) {
        StringBuffer buffer = new StringBuffer();

        while (!stack.empty()) {
            buffer.append(stack.pop());
        }

        return buffer.reverse().toString();
    }
}
