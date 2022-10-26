package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();

        for (char c: cryptogram.toCharArray()) {
            if (stack.peek() == c)
                stack.pop();
            else
                stack.push(c);
        }

        String result = "";

        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }

        return result;
    }
}
