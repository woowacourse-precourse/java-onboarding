package onboarding;

import java.util.ArrayList;
import java.util.Stack;

public class Problem2 {

    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();

        for (char character : cryptogram.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(character);
            } else {
                if (stack.peek().equals(character)) {
                    stack.pop();
                } else {
                    stack.push(character);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : new ArrayList<>(stack)) {
            sb.append(character);
        }

        return sb.toString();
    }
}
