package onboarding;

import java.util.Stack;

public class Problem2 {
    private static final Stack<Character> stack = new Stack<>();

    public static String solution(String cryptogram) {
        for (int index = 0 ; index < cryptogram.length() ; index++) {
            if (stack.isEmpty()) {
                stack.add(cryptogram.charAt(index));
            } else {
                removeDuplicateString(index, cryptogram);
            }
        }

        return getOriginalInformation();
    }

    private static void removeDuplicateString(int index, String cryptogram) {
        if (stack.peek() == cryptogram.charAt(index)) {
            stack.pop();
        } else {
            stack.add(cryptogram.charAt(index));
        }
    }

    private static String getOriginalInformation() {
        StringBuilder cryptogram = new StringBuilder();

        while (!stack.isEmpty()) {
            cryptogram.append(stack.pop());
        }

        return cryptogram.reverse().toString();
    }
}
