package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.*;

class Problem2Test {

    @Nested
    class LogicTest {
        @Test
        @DisplayName("모두 없어지는 경우")
        void case1() {
            assertThat(getAnswer("zyelleyz".toCharArray())).isEqualTo("");
            assertThat(getAnswer("aabbccddeeeee".toCharArray())).isEqualTo("");
            assertThat(getAnswer("aaaaa".toCharArray())).isEqualTo("");
        }

        @Test
        @DisplayName("모두 없어지지 않는 경우")
        void case2() {
            assertThat(getAnswer("browoanoommnaon".toCharArray())).isEqualTo("brown");
        }

        @Test
        @DisplayName("결과가 그대로")
        void case3() {
            assertThat(getAnswer("abcdef".toCharArray())).isEqualTo("abcdef");
        }
    }


    private String getAnswer(char[] charArray) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char history = ' ';
        for (char target : charArray) {
            history = isValid(stack, history, target);
        }
        for (Character c : stack) {
            answer.append(c);
        }
        return answer.toString();
    }

    private char isValid(Stack<Character> stack, char history, char target) {
        if (!stack.isEmpty() && stack.peek() == target) {
            history = stack.pop();
        } else if (history != target) {
            stack.push(target);
        }
        return history;
    }

}