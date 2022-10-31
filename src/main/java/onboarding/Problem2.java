package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        StringBuilder sb = new StringBuilder();
        
        Stack<Character> s = new Stack<>();
        for(int i=cryptogram.length()-1;i>=0;i--) {
        	if(s.size()==0) {
        		s.push(cryptogram.charAt(i));
        	}else {
        		if(s.peek()!=cryptogram.charAt(i)) {
            		s.push(cryptogram.charAt(i));
            	}else {
            		s.pop();
            	}
        	}
        }
        
        if(s.isEmpty())answer="";
        else {
        	while(!s.isEmpty()) {
            	sb.append(s.pop());
            }
            answer = sb.toString();
        }
         return answer;
    }
}
