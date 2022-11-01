package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        Stack<Character> charStack = new Stack<>();
        for (int i = 0; i < cryptogram.length(); i++) {
            char c = cryptogram.charAt(i);
            if (charStack.isEmpty()) {
                charStack.push(c);
            } else if (charStack.peek() == c) {
                charStack.pop();
            } else {
                charStack.push(c);
            }

        }
        while (!charStack.isEmpty()) {
            answer = charStack.pop() + answer;
        }

        return answer;
    }
}