package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        Stack<Character> stack = checkDuplicate(cryptogram);
        return answer;
    }

    private static Stack<Character> checkDuplicate(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        stack.push(cryptogram.charAt(0));
        char before = stack.peek();

        for (int i = 1; i < cryptogram.length(); i++) {
            char after = cryptogram.charAt(i);
            if (before == after) {
                stack.pop();
                if(!stack.isEmpty()) {
                    before = stack.peek();
                }
            } else {
                stack.push(cryptogram.charAt(i));
                before = cryptogram.charAt(i);
            }
        }
        return stack;
    }
}
