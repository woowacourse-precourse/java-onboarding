package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> stack = removeDuplicate(cryptogram);
        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
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
