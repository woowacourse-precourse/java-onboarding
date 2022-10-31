package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> s = new Stack<>();


        for (Character c: cryptogram.toCharArray()) {
            if (!s.empty() && s.peek() == c) {
                s.pop();
                continue;
            }
            s.push(c);
        }

        return stackToString(s);
    }

    private static String stackToString(Stack<Character> stack) {
        StringBuilder result = new StringBuilder();

        while (!stack.empty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }
}



