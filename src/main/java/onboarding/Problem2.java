package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<=cryptogram.length();i++) {
        	char next_char;
        	
        	if(i==cryptogram.length()) {
        		next_char = '1';
        	}else {
        		next_char = cryptogram.charAt(i);
        	}
        	
        	if(stack.size()==0) {
        		stack.add(next_char);
        		continue;
        	}
        	
        	char cur_char = stack.pop();
        	if(next_char!=cur_char) {
        		boolean plag = true;
        		while(!stack.isEmpty()) {
        			char before_char = stack.pop();
        			if(before_char!=cur_char) {
        				stack.add(before_char);
        				break;
        			}
        			
    				plag = false;
        		}
        		
        		if(plag) {
        			stack.add(cur_char);
        		}
        	}else {
        		stack.add(cur_char);
        	}
        	
        	stack.add(next_char);
        }
        
        stack.pop();
        
        
        while(!stack.isEmpty()) {
        	sb.append(stack.pop());
        }
        
        sb.reverse();
        
        return sb.toString();
    }
}
