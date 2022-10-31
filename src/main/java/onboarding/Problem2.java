package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    private static Stack<Character> decodeCryptogram(String cryptogram) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < cryptogram.length(); i++) {
            if (!stack.empty() && cryptogram.charAt(i) == stack.peek()) {
                stack.pop();
            }else {
                stack.push(cryptogram.charAt(i));
            }
        }
        return stack;
    }
}
