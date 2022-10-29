package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        for (char c : cryptogram.toCharArray()) {
            stack = checkCharacterRepetition(stack, c);
        }
        return stackToString(stack);
    }

    public static String stackToString(Stack<Character> stack) {
        String answer = "";
        for (char c : stack) {
            answer += c;
        }
        return answer;
    }

    public static Stack<Character> checkCharacterRepetition(Stack<Character> stack, char c) {
        if (isStackElementExists(stack) && isStackTopEqualsCharacter(stack, c)) {
            return popStack(stack);
        }
        return pushStack(stack, c);
    }

    public static Stack popStack(Stack stack) {
        stack.pop();
        return stack;
    }

    public static Stack pushStack(Stack stack, char c) {
        stack.push(c);
        return stack;
    }

    private static boolean isStackElementExists(Stack stack) {
        return !stack.isEmpty();
    }

    private static boolean isStackTopEqualsCharacter(Stack<Character> stack, char c) {
        return stack.peek() == c;
    }

}
