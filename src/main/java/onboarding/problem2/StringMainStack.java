package onboarding.problem2;

import java.util.Stack;

public class StringMainStack {

    private final Stack<Character> stack = new Stack<>();

    public void pushString(String input) {
        char[] character = input.toCharArray();
        for (char c : character) {
            this.stack.push(c);
        }
    }

    public Character popCharacter() {
        return this.stack.pop();
    }

    public Stack<Character> getStack() {
        return this.stack;
    }

    public Character getPeek() { return this.stack.peek();}

    public boolean isEmpty() {
        return this.stack.isEmpty();
    }
}
