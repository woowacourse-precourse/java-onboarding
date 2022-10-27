package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        return deduplication(cryptogram);
    }

    private static String deduplication(String cryptogram) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < cryptogram.length(); i++) {
            char tempChar = cryptogram.charAt(i);

            if (stack.empty()) {
                stack.push(tempChar);
            } else if (stack.peek() == tempChar) {
                stack.pop();
            } else {
                stack.push(tempChar);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }

        if (cryptogram.length() == stack.size()) {
            return cryptogram;
        }

        return deduplication(sb.toString());
    }
}
