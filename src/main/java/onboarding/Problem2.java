package onboarding;

import java.util.Stack;

public class Problem2 {
    static Stack<Character> stack=new Stack<>();
    public static String solution(String cryptogram) {
        StringBuilder sb=new StringBuilder();
        distinctElement(cryptogram);
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void distinctElement(String cryptogram){
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
    }
}
