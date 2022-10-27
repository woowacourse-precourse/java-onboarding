package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (Character c : cryptogram.toCharArray()) {
            if (stack.isEmpty()) stack.push(c);
            else {
                if (stack.peek() != c) stack.push(c);
                else stack.pop();
            }
        }

        for (Character c : stack) {
            answer.append(c);
        }

        return answer.toString();
    }
}
