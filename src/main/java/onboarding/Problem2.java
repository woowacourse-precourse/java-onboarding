package onboarding;


import java.util.Stack;


public class Problem2 {
    private static Stack<Character> STACK;

    public static String solution(String cryptogram) {
        init();
        removeDuplicateString(cryptogram);
        return getResultFromStack();
    }

    private static void init() {
        STACK = new Stack<>();
    }

    private static void removeDuplicateString(String cryptogram) {
        Character prev = ' ';

        for(Character c : cryptogram.toCharArray()){
            if (STACK.empty()) {
                STACK.push(c);
                continue;
            }

            if (STACK.peek().equals(c)) {
                STACK.pop();
            } else if (!prev.equals(c)) {
                STACK.push(c);
            }
            prev = c;
        }
    }

    private static String getResultFromStack() {
        StringBuilder stringBuilder = new StringBuilder();
        while (!STACK.isEmpty()) {
            stringBuilder.append(STACK.pop());
        }
        return stringBuilder.length() == 0 ? "" : stringBuilder.reverse().toString();
    }
}
