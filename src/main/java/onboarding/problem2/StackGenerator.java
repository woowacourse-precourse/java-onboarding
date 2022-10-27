package onboarding.problem2;

import java.util.Stack;

public class StackGenerator {

    public Stack<String> createStack(String cryptogram) {

        Stack<String> stack = new Stack<>();

        String[] cryptogramSplit = cryptogram.split("");

        for (int i = 0; i < cryptogramSplit.length; i++) {

            stack.push(cryptogramSplit[i]);

        }

        return stack;
    }
}
