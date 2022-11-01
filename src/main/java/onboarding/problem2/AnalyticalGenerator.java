package onboarding.problem2;

import java.util.Stack;

public class AnalyticalGenerator {

    public Stack<String> analyzer(String cryptogram) {

        Stack<String> stack = new Stack<>();
        String[] split = cryptogram.split("");

        stack.push(split[0]);

        for (int i = 1; i < split.length; i++) {

            if (stack.size() > 0 && stack.peek().equals(split[i])) {
                stack.pop();
            } else {
                stack.push(split[i]);
            }
        }

        return stack;
    }
}
