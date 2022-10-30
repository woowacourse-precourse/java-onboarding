package onboarding;

import java.util.Stack;

public class Problem2 {
    static int ERROR_NUM = -1;

    public static String solution(String cryptogram) {
        try {
            Stack<Character> decodedCryptogram = deleteChar(cryptogram);
            return convertToString(decodedCryptogram);
        } catch (Exception e) {
            return Integer.toString(ERROR_NUM);
        }
    }

    public static String convertToString(Stack<Character> stack) {
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        return result.toString();
    }

    public static Stack<Character> deleteChar(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        for (char c : cryptogram.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack;
    }
}
