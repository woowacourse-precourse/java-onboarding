package onboarding;

import java.util.Stack;

public class Problem2 {

    public static String solution(String cryptogram) {

        String ans = "";
        char pre = cryptogram.charAt(0);

        Stack<Character> stack = new Stack<>();
        stack.push(pre);

        for (int i = 1; i < cryptogram.length(); ++i) {
            if (cryptogram.charAt(i) == stack.peek()) {
                stack.pop();
            } else {
                stack.push(cryptogram.charAt(i));
            }
        }

        for (int i = 0; i < stack.size(); ++i) {
            ans += stack.get(i);
        }

        return ans;

    }
}
