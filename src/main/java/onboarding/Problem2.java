package onboarding;

import java.util.Stack;

public class Problem2 {

    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        char[] answer = cryptogram.toCharArray();

        for (int i = 0; i < answer.length; i++) {
            if (isNotEmptyAndPeekEquals(stack, answer[i])) {
                stack.pop();
            } else {
                stack.push(answer[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        //stack 값 출력
        for (char ch : stack) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public static boolean isNotEmptyAndPeekEquals(Stack<Character> stack, char answer) {
        return !stack.empty() && stack.peek().equals(answer);
    }
}
