package onboarding.problem2;

import java.util.Stack;

public class Operator {
    public static Stack<Character> deleteDuplicate(Stack<Character> originalStack) {
        Stack<Character> result = new Stack<>();
        char duplicate = 0;

        while (!originalStack.isEmpty()) {
            Character pop = originalStack.pop();

            if (isDuplicated(result, pop)) {
                duplicate = pop;
                result.pop();
                continue;
            }

            if (pop != duplicate) {
                result.add(pop);
                duplicate = 0;
            }
        }

        return result;
    }

    private static boolean isDuplicated(Stack<Character> result, Character pop) {
        return !result.isEmpty() && pop == result.peek();
    }

    public static String makeStackToString(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();

        while (!stack.empty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static Stack<Character> makeStringToStack(String string) {
        Stack<Character> stack = new Stack<>();

        for (char letter : string.toCharArray()) {
            stack.add(letter);
        }

        return stack;
    }
}