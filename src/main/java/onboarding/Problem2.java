package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char[] charArray = cryptogram.toCharArray();
        char history = ' ';

        for (char target : charArray) {
            history = isValid(stack, history, target);
        }
        for (Character c : stack) {
            answer.append(c);
        }
        return answer.toString();
    }

    private static char isValid(Stack<Character> stack, char history, char target) {
        if (!stack.isEmpty() && stack.peek() == target) {
            history = stack.pop();
        } else if (history != target) {
            stack.push(target);
        }
        return history;
    }
}
