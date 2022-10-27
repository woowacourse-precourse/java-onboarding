package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {
    public static String removeDuplication(String cipher) {
        Stack<Character> stack = new Stack<>();

        cipher.chars()
                .forEach(o -> {
                    if (!stack.isEmpty() && stack.peek() == o)
                        stack.pop();
                    else
                        stack.add((char) o);
                });

        return stack.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }

    public static String solution(String cryptogram) {
        return removeDuplication(cryptogram);
    }
}
