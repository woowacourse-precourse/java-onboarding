package onboarding;

import java.util.Stack;

public class Problem2 {
    private static StringBuilder sb;
    public static String solution(String cryptogram) {
        Stack<Character> stack = checkDuplication(cryptogram);
        stackToString(stack);

        return sb.toString();
    }

    private static void stackToString(Stack<Character> stack) {
        sb = new StringBuilder();
        stack.forEach(alphabet -> {
            sb.append(alphabet);
        });
    }

    private static Stack<Character> checkDuplication(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        stack.push(cryptogram.charAt(0));
        char before = stack.peek();

        for (int i = 1; i < cryptogram.length(); i++) {
            char after = cryptogram.charAt(i);
            if (before == after) {
                stack.pop();
                if(!stack.isEmpty()) {
                    before = stack.peek();
                }
            } else {
                stack.push(cryptogram.charAt(i));
                before = cryptogram.charAt(i);
            }
        }
        return stack;
    }
}
