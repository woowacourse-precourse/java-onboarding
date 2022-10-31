package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        return decode(cryptogram);
    }

    private static String decode(String cryptogram) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < cryptogram.length(); i++) {
            char c = cryptogram.charAt(i);

            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            } else if (stack.peek().equals(c)) {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}


