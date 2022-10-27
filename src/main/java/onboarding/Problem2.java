package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> stack = removeDuplicate(cryptogram);

        return "";
    }

    private static Stack<Character> removeDuplicate(String cryptogram) {
        Stack<Character> stack = new Stack<>();

        for (char ch : cryptogram.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
                continue;
            }

            stack.push(ch);
        }

        return stack;
    }
}
