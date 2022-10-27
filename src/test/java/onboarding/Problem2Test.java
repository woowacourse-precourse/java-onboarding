package onboarding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class Problem2Test {

    @Test
    void logicTest() {
        StringBuilder answer = new StringBuilder();
        char[] chars = "browoanoommnaon".toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch : chars) {
            isValid(stack, ch);
        }

        for (Character c : stack) {
            answer.append(c);
        }
        assertThat(answer.toString()).isEqualTo("brown");
    }

    private void isValid(Stack<Character> stack, char ch) {
        if (!stack.isEmpty() && stack.peek() == ch) {
            stack.pop();
            return;
        }
        stack.push(ch);
    }
}