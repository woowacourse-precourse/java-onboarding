package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<String> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        String[] strings = cryptogram.split("");

        stringStack(stack, strings);

        for (String a : stack) {
            sb.append(a);
        }

        return String.valueOf(sb);
    }

    private static Stack<String> stringStack(Stack<String> stack, String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            if (!stack.isEmpty() && stack.peek().equals(strings[i])) {
                stack.pop();
            } else {
                stack.push(strings[i]);
            }
        }

        return stack;
    }
}
