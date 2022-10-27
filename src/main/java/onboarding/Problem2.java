package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char[] chars = cryptogram.toCharArray();

        for (char ch : chars) {
            isValid(stack, ch);
        }

        for (Character c : stack) {
            answer.append(c);
        }
        return answer.toString();
    }

    private static void isValid(Stack<Character> stack, char ch) {
        if (!stack.isEmpty() && stack.peek() == ch) {
            stack.pop();
            return;
        }
        stack.push(ch);
    }
}
