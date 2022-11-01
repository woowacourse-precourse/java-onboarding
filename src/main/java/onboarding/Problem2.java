package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder answer = new StringBuilder();
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
            answer.insert(0, charStack.pop());
        }

        return answer.toString();
    }
}