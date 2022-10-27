package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        stack.push(cryptogram.charAt(0));

        for (int i = 1; i < cryptogram.length(); i++) {
            char ch = cryptogram.charAt(i);
            if (stack.peek() == ch) {
                stack.pop();
            }

            else {
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }

        return answer.reverse().toString();
    }
}
