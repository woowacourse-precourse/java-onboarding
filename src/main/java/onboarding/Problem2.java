package onboarding;

import java.util.Stack;

public class Problem2 {
    public static final char NOT_LOWER_CASE = '0';
    public static final int MINIMUM_STRING_LENGTH = 1;
    public static final int MAXIMUM_STRING_LENGTH = 1000;

    public static String solution(String cryptogram) {
        validateString(cryptogram);

        Stack<Character> cryptogramStack = stringToStack(cryptogram);
        Stack<Character> filteredStack = filterDuplicatedChar(cryptogramStack);

        return stackToString(filteredStack);
    }

    public static void validateString(String string) {
        validateRange(string);
        validateLowerCase(string);
    }

    public static void validateRange(String string) {
        if (string.length() < MINIMUM_STRING_LENGTH || string.length() > MAXIMUM_STRING_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateLowerCase(String string) {
        for (char letter : string.toCharArray()) {
            if (!Character.isLowerCase(letter)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static Stack<Character> filterDuplicatedChar(Stack<Character> originalStack) {
        Stack<Character> resultStack = new Stack<>();
        char duplicateChar = NOT_LOWER_CASE;

        while (!originalStack.isEmpty()) {
            Character pop = originalStack.pop();

            if (!resultStack.isEmpty() && pop == resultStack.peek()) {
                duplicateChar = pop;
                resultStack.pop();
                continue;
            }

            if (pop != duplicateChar) {
                resultStack.add(pop);
                duplicateChar = NOT_LOWER_CASE;
            }
        }

        return resultStack;
    }

    public static String stackToString(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();

        while (!stack.empty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static Stack<Character> stringToStack(String string) {
        Stack<Character> stack = new Stack<>();

        for (char letter : string.toCharArray()) {
            stack.add(letter);
        }

        return stack;
    }
}
