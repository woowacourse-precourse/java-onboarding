package onboarding;

import java.util.Stack;

public class Problem2 {
    private static int checkCryptogram(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return 0;
            }
        }
        if (str.length() < 1 || str.length() > 1000) {
            return -1;
        }
        return 1;
    }
    private static String reverseString(String str) {
        String result = "";
        for (int i = (str.length() - 1); i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
    public static String solution(String cryptogram) {
        if (checkCryptogram(cryptogram) == 0) {
            return "UpperCaseError";
        } else if (checkCryptogram(cryptogram) == -1) {
            return "outOfStringRangeError";
        }

        String result = "";
        Stack<Character> stack = new Stack<>();
        for (char c : cryptogram.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            }
            else {
                stack.add(c);
            }
        }

        int stackSize = stack.size();
        for (int i = 0; i < stackSize; i++) {
            result += stack.pop();
        }

        return reverseString(result);
    }
}
