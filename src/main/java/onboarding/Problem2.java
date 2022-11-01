package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        Stack<Character> stack=new Stack<Character>();
        stack.push(cryptogram.charAt(0));
        for(int i=1;i<cryptogram.length();i++){
            char x=cryptogram.charAt(i);
            if(stack.peek()==x)
                stack.pop();
            else
                stack.push(x);
        }
        for(char c:stack)
            answer+=c;
        return answer;
    }
}
