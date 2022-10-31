package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder sb = new StringBuilder();
        
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<cryptogram.length();i++) {
        	char cur_char = cryptogram.charAt(i);
        	
        	if(stack.size()!=0 && stack.peek()==cur_char) {
        		stack.pop();
        	}else {
        		stack.add(cur_char);
        	}
        }
        
        while(!stack.isEmpty()) {
        	sb.append(stack.pop());
        }
        
        sb.reverse();
        
        return sb.toString();
    }
}
