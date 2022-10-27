package onboarding;

import java.util.Stack;

public class Problem2 {
    private static String reverseString(String str) {
        String result = "";
        for (int i = (str.length() - 1); i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
    public static String solution(String cryptogram) {
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
