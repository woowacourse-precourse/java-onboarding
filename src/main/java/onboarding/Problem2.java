package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char prevCharacter = 0;

        for (int i = 0; i < cryptogram.length(); i++) {
            char c = cryptogram.charAt(i);
            if (stack.empty()) {
                stack.add(c);
            }
            else {
                if (stack.peek().equals(c)) {
                    stack.pop();
                    prevCharacter = c;
                }
                else {
                    if (prevCharacter != c) {
                        stack.add(c);
                    }
                }
            }
        }

        for (Character c : stack) {
            answer.append(c);
        }

        return answer.toString();
    }
}
