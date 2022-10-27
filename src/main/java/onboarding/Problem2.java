package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = decrypt(cryptogram);
        return answer;
    }

    public static String decrypt(String cryptogram) {
        int length = cryptogram.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            char ch = cryptogram.charAt(i);

            if (!stack.isEmpty() && ch == stack.peek()) {
                if (i < length - 1) {
                    char nextCh = cryptogram.charAt(i + 1);

                    if (ch == nextCh) {
                        continue;
                    }
                }
                stack.pop();
                continue;
            }

            stack.add(ch);
        }

        StringBuilder sb = new StringBuilder();
        for (Character ch : stack) {
            sb.append(ch);
        }

        return sb.toString();
    }
}
