package onboarding;

import java.util.Stack;

public class Problem2 {
    static Stack<Character> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    public static String solution(String cryptogram) {
        String answer = "";
        stack.push(cryptogram.charAt(0));
        for(int i=1; i<cryptogram.length(); i++){
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
