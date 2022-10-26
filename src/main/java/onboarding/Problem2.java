package onboarding;

import java.util.Stack;

public class Problem2 {

    public static String solution(String cryptogram) {
        String answer = "answer";
        Stack<Character> stack = new Stack<>();
        int len = cryptogram.length();
        for (int i = 0; i < len; i++) {
            char ch = cryptogram.charAt(i);

            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.add(ch);
            }
        }

        return answer;
    }
}
