package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        for (char c : cryptogram.toCharArray()) {
            stack = checkRepetition(stack, c);
        }
        return stackToString(stack);
    }

    public static String stackToString(Stack<Character> stack) {
        String answer = "";
        for (char c : stack) {
            answer += c;
        }
        return answer;
    }

    // 이름과 행위가 안맞음
    // 메서드의 역할을 최대한 작게 - S of  SOLID
    // 하튼 함수에서 분리하면 else 없앨 수 있음
    public static Stack<Character> checkRepetition(Stack<Character> stack, char c) {
        if (!stack.isEmpty() && stack.peek() == c) {
            return popStack(stack);
        }
        return pushStack(stack, c);
    }

    public static Stack popStack(Stack stack) {
        stack.pop();
        return stack;
    }

    public static Stack pushStack(Stack stack, char c) {
        stack.push(c);
        return stack;
    }

}
