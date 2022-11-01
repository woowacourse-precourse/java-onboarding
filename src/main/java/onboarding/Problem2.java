package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for(char c : cryptogram.toCharArray()){
            if(stack.isEmpty()){
                stack.push(c);
            }else{
                if(stack.peek()==c){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.peek());
            stack.pop();
        }

        answer = String.valueOf(sb.reverse());
        return answer;
    }
}
