package onboarding;

import java.util.Stack;

public class Problem2 {
    static Stack<Character> stack;
    static StringBuilder sb;
    public static String solution(String cryptogram) {
        stack = new Stack<>();
        sb = new StringBuilder();
        for(int i=0; i<cryptogram.length(); i++){
            if(i == 0 || stack.isEmpty()) {
                stack.push(cryptogram.charAt(i));
                continue;
            }
            if(stack.peek() == cryptogram.charAt(i)) stack.pop();
            else{
                stack.push(cryptogram.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
