package onboarding;

import onboarding.problem2.Cryptogram;

import java.util.Stack;

public class Problem2 {
    public static String solution(String message) {
        Cryptogram cryptogram = new Cryptogram(message);

        Stack<Character> stack = new Stack<>();

        for (char c: cryptogram.getMessage().toCharArray()) {
            if (stack.size() > 0 && stack.peek() == c)
                stack.pop();
            else
                stack.push(c);
        }

        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }
}
