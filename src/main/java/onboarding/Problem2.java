package onboarding;

import java.util.Stack;

public class Problem2 {

    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();

        for (Character word : cryptogram.toCharArray()){
            if(stack.isEmpty()) {
                stack.push(word);
                continue;
            }
            Character before = stack.peek();
            if(before.equals(word)) {
                stack.pop();
            } else {
                stack.push(word);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }

        return sb.toString();
    }
}
