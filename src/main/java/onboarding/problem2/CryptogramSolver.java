package onboarding.problem2;

import java.util.Stack;

public class CryptogramSolver {

    public String convertStackToString(Stack<Character> stack) {
        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }

    public String solve(Cryptogram cryptogram) {
        Stack<Character> stack = new Stack<>();

        for (char c: cryptogram.getMessage().toCharArray()) {
            if (stack.size() > 0 && stack.peek() == c)
                stack.pop();
            else
                stack.push(c);
        }

        return convertStackToString(stack);
    }
}
