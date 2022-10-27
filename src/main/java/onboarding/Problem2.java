package onboarding;

import java.util.Stack;

public class Problem2 {
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
        return result;
    }
}
