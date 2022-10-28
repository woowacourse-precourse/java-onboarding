package onboarding;

import java.util.Stack;

public class Problem2 {

    public static String solution(String cryptogram) {

        if (isNotValidateCryptogram(cryptogram)) {
            throw new IllegalArgumentException();
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < cryptogram.length(); i++) {
            char c = cryptogram.charAt(i);

            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }

    private static boolean isNotValidateCryptogram(String cryptogram) {

        int length = cryptogram.length();
        if (length < 1 || length > 1000) {
            return true;
        }

        for (int i = 0; i < length; i++) {
            char c = cryptogram.charAt(i);

            if (!Character.isLowerCase(c)) {
                return true;
            }
        }

        return false;
    }
}
