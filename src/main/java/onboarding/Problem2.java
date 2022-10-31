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

    private static void removeDuplicateString(String str) {
        for (Character c : str.toCharArray()) {
            if(!STACK.isEmpty()) {
                Character last = STACK.peek();
                int duplicate = 0;
                if (!c.equals(last)) {
                    removeDuplicateByStack(last, duplicate);
                }
            }
            STACK.add(c);
        }

        Character last = STACK.peek();
        int duplicate = 0;
        removeDuplicateByStack(last, duplicate);
    }

    private static void removeDuplicateByStack(Character last, int cnt) {
        for (int i = STACK.size(); i > 0; i--) {
            if (last != STACK.elementAt(i-1)) {
                break;
            }
            cnt += 1;
        }

        if (cnt > 1) {
            for (int i = 0; i < cnt; i++) {
                STACK.pop();
            }
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
