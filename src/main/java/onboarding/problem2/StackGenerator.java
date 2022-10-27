package onboarding.problem2;

import java.util.Stack;

public class StackGenerator {

    public Stack<String> createStack(String cryptogram) {

        Stack<String> stack = new Stack<>();
        String[] split = cryptogram.split("");

        for (int i = 0; i < split.length - 1; i++) {

            if (split[i].equals(split[i + 1])) {
                continue;

            } else {
                stack.push(split[i]);

                if (i >= 1 && split[i].equals(split[i - 1])) {
                    stack.pop();
                }
            }
        }

        return stack;
    }
}
