package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();

        char popped = ' ';
        for (char letter : cryptogram.toCharArray()) {
            if (letter == popped) continue;
            if (!stack.isEmpty() && stack.peek() == letter) {
                popped = stack.pop();
                continue;
            }
            stack.push(letter);
        }
        return characterStackToString(stack);
    }

    static String characterStackToString(Stack<Character> stack) {
        StringBuilder result = new StringBuilder(stack.size());
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
}
