package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        return decrypt(cryptogram);
    }

    private static String decrypt(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        char[] chars = cryptogram.toCharArray();

        for (char c : chars) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        return stack.toString();
    }
}

