package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {

    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        int len = cryptogram.length();
        for (int i = 0; i < len; i++) {
            char ch = cryptogram.charAt(i);

            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.add(ch);
            }
        }

        return stack.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
