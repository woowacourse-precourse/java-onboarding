package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Problem2Test {
    @Test
    @DisplayName("대문자 포함")
    void case1() {
        String cryptogram = "browoAnoommnaoN";
        assertThrows(RuntimeException.class, () -> Problem2.solution(cryptogram));
    }

    @Test
    @DisplayName("한글 포함")
    void case2() {
        String cryptogram = "browoㅁnoommnao바";
        assertThrows(RuntimeException.class, () -> Problem2.solution(cryptogram));
    }

    @Test
    @DisplayName("String 길이 0")
    void case3() {
        String cryptogram = "";
        assertThrows(RuntimeException.class, () -> Problem2.solution(cryptogram));
    }

    @Test
    void case4() {
        String cryptogram = "abbaa";
        String result = "a";
        assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }

    @Test
    void case5() {
        String cryptogram = "aazzqweqweaaq";
        String result = "qweqweq";
        assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }

    @Test
    @DisplayName("메서드 실행 시간 비교")
    void checkRunTime() {
        Stack<Character> stack = createStack();
        long startTime;
        long finishTime;
        String result;

        startTime = System.nanoTime();
        result = combineLetter1(stack);
        finishTime = System.nanoTime();
        System.out.println("# 메서드 1 : " + result);
        System.out.println("# 실행시간 : " + (finishTime - startTime));

        startTime = System.nanoTime();
        result = combineLetter2(stack);
        finishTime = System.nanoTime();
        System.out.println("# 메서드 2 : " + result);
        System.out.println("# 실행시간 : " + (finishTime - startTime));

        startTime = System.nanoTime();
        result = combineLetter3(stack);
        finishTime = System.nanoTime();
        System.out.println("# 메서드 3 : " + result);
        System.out.println("# 실행시간 : " + (finishTime - startTime));
    }

    private String combineLetter1(Stack<Character> stack) {
        int size = stack.size();
        String[] letterArray = new String[size];
        size--;

        while (!stack.empty()) {
            char letter = stack.pop();
            letterArray[size--] = String.valueOf(letter);
        }
        return String.join("", letterArray);
    }

    private String combineLetter2(Stack<Character> stack) {
        int size = stack.size();
        String[] letterArray = new String[size];
        size--;

        while (!stack.empty()) {
            char letter = stack.pop();
            letterArray[size--] = String.valueOf(letter);
        }
        return Arrays.stream(letterArray).collect(Collectors.joining());
    }

    private String combineLetter3(Stack<Character> stack) {
        String letters = String.join("", stack.toString());
        return letters
                .replace("[", "")
                .replace(", ", "")
                .replace("]", "");
    }

    private Stack<Character> createStack() {
        Stack<Character> stack = new Stack<>();
        char[] arr = {'b', 'r', 'o', 'w', 'n'};
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }
        return stack;
    }
}
