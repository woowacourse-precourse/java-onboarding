package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> stack = getCharacterStack(cryptogram);
        return getStringBuilder(stack);
    }

    private static String getStringBuilder(Stack<Character> stack) {
        return stack.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public static Stack<Character> getCharacterStack(String cryptogram) {
        return removeDuplicatedCharacter(cryptogram);
    }

    private static Stack<Character> removeDuplicatedCharacter(String cryptogram) {
        Stack<Character> stack = new Stack<>();

        cryptogram.chars()
                .forEach(i -> {
                    if (!stack.isEmpty() && stack.peek() == i) {
                        stack.pop();
                    } else {
                        stack.push((char) i);
                    }
                });
        return stack;
    }
}
