package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        return removeDuplicateString(cryptogram);
    }

    public static String removeDuplicateString(String str) {
        Stack<Character> stack = new Stack<>();
        str.chars().forEach(i -> {
            if (!stack.isEmpty() && stack.peek() == i) {
                stack.pop();
            } else
                stack.push((char) i);
        });
        return charStackToString(stack);
    }

    public static String charStackToString(Stack<Character> stack) {
        return stack.stream()
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}