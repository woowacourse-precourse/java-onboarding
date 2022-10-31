package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<String> stack = new Stack<>();
        String prev="";

        for(String c : cryptogram.split("")){
            if (stack.empty())
                stack.push(c);
            else if (stack.peek().equals(c))
                stack.pop();
            else if(! prev.equals(c))
                stack.push(c);

            prev=c;
        }

        return String.join("", stack);
    }
}
