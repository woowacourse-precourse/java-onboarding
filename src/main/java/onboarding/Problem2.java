package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for (char a : cryptogram.toCharArray()) {
            if (!stack.isEmpty()) {
                if (stack.peek() == a) {
                    stack.pop();
                } else {
                    stack.push(a);
                }
            } else {
                stack.push(a);
            }
        }
        for (char b : stack) {
            answer += b;
        }
        return answer;
    }
}
