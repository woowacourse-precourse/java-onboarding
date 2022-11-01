package onboarding.problem2;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecryptStack {
    private final ArrayDeque<Character> stack = new ArrayDeque<>();

    public void push(char c) {
        stack.push(c);
    }

    public Character pop() {
        return stack.pop();
    }

    public Character peek() {
        return stack.peek();
    }
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public String getPassword() {
        StringBuilder stringBuilder = new StringBuilder();
        Deque<Character> cloneStack = stack.clone();
        while (!cloneStack.isEmpty()) {
            stringBuilder.append(cloneStack.pop());
        }

        return stringBuilder.reverse().toString();
    }
}
