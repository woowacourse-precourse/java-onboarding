package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();

        char[] chars = cryptogram.toCharArray();
        for (Character aChar : chars) {
            duplicateCheck(stack, aChar);
        }

        return stack.stream().map(String::valueOf).collect(Collectors.joining());
    }

    private static void duplicateCheck(Stack<Character> stack, Character aChar) {
        if (stack.isEmpty()) {
            stack.push(aChar);
            return;
        }
        if (stack.peek().equals(aChar)) {
            stack.pop();
            return;
        }
        stack.push(aChar);
    }

}