package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        for (int i=0 ; i < cryptogram.length() ; i++) {
            char letter = cryptogram.charAt(i);
            if (stack.isEmpty() || letter != stack.peek()) {
                stack.add(letter);
            }
            else if (!stack.isEmpty() && letter == stack.peek()) {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
