package onboarding;

import java.util.Stack

public class Problem2 {
    public static String erase(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length; i++) {
            char c = s.charAt(i);
            if (stack != null && stack.peek() == c) {
                stack.pop();
            }
            else{
                stack.push(c);
            }
        }
        String res = String.join("", stack);
        return res;
    }
    public static void solution(String cryptogram) {
        System.out.println(erase(cryptogram));
    }
}
