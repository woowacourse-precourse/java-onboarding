package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        int index = 0;

        while (index < cryptogram.length()) {
            char currentChar = cryptogram.charAt(index);

            if (stack.isEmpty() || stack.peek() != currentChar) {
                stack.push(currentChar);
            } else {
                do {
                    index++;
                }
                while (index < cryptogram.length() && stack.peek() == cryptogram.charAt(index));
                stack.pop();
                index--;
            }
            index++;
        }

        return stackToString(stack);
    }

    private static String stackToString(Stack<Character> stack) {
        String string = "";
        for (Character c : stack) {
            string += c;
        }

        return string;
    }
}
