package onboarding;

import java.util.Stack;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        char[] chars = cryptogram.toCharArray();
        duplicateCheck(stack, chars);

        return stack.stream().map(String::valueOf).collect(Collectors.joining());
    }

    private static void duplicateCheck(Stack<Character> stack, char[] chars) {
        int count = 0;
        for (char aChar : chars) {
            stackProcess(stack, chars, aChar, count);
            count++;
        }
    }

    private static void stackProcess(Stack<Character> stack, char[] chars, char aChar, int count) {
        if (stack.isEmpty()) {
            stack.push(aChar);
            return;
        }
        if (stack.peek().equals(aChar)) {
            stack.pop();
            return;
        }
        if (aChar != chars[count - 1]) {
            stack.push(aChar);
        }
    }
}