package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder sb=new StringBuilder();
        Stack<Character> stack=new Stack<>();
        for (char x:cryptogram.toCharArray()){
            if (stack.isEmpty()) stack.push(x);
            else {
                char peek = stack.peek();
                if (x==peek) {
                    stack.pop();
                    continue;
                }
                stack.push(x);
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
