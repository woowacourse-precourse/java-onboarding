package onboarding;

import java.util.Stack;

public class Problem2 {
    private Stack<Character> stack = new Stack<Character>();

    public static String solution(String cryptogram) {
        Problem2 p2 = new Problem2();
        p2.putIntoStack(cryptogram);
        String result = p2.transToString();
        return result;
    }

    private void putIntoStack(String cryptogram){
        for(char c : cryptogram.toCharArray()){
            if(stack.empty()) stack.push(c);
            else if(stack.peek() != c) stack.push(c);
            else{
                while(stack.peek() != c) stack.pop();
            }
        }
    }

    private String transToString(){
        StringBuilder sb = new StringBuilder();
        while(!stack.empty()){
            sb.append(stack.peek());
            stack.pop();
        }
        return sb.reverse().toString();
    }
}
