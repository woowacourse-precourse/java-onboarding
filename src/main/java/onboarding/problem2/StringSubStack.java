package onboarding.problem2;

import java.util.Stack;

public class StringSubStack {

    private final Stack<Character> stack = new Stack<>();

    public Stack<Character> getStack() {
        return this.stack;
    }

    public void pushCharacter(Character character) {
        this.stack.push(character);
    }

    public Character popCharacter() {
        return this.stack.pop();
    }

    public String makeString() {
        StringBuilder stringBuilder = new StringBuilder();
        while(!this.stack.isEmpty()) {
            stringBuilder.append(this.stack.pop());
        }
        return stringBuilder.toString();
    }

    public Character getPeek() {
        return this.stack.peek();
    }

    public boolean isEmpty() {
        return this.stack.isEmpty();
    }
}
