package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String s1 = "";
        Stack<Character> stack = new Stack<>();
        char[] s_arr = cryptogram.toCharArray();

        for (char c : s_arr) {
            if (stack.empty()) {
                stack.push(c);
            } else {
                if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        for (Character character : stack) {
            s1+=character;
        }
      return s1;
    }


}
