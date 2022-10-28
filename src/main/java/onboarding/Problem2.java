package onboarding;

public class Problem2 {
    public static final char NOT_LOWER_CASE = '0';
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
        Stack<Character> cryptogramStack = stringToStack(cryptogram);
        Stack<Character> filteredStack = filterDuplicatedChar(cryptogramStack);

        return stackToString(filteredStack);
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
