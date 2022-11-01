package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();

        for (char ch : cryptogram.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
                continue;
            }
            stack.push(ch);
        }

        return stack.stream().map(Object::toString).collect(Collectors.joining(""));
    }
}