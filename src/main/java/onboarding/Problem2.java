package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < cryptogram.length(); i++) {
            if (!stack.isEmpty()) {
                if (stack.peek() == cryptogram.charAt(i)) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(cryptogram.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
