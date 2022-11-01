package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        
        boolean flag = false;
        Stack<Character> stack = new Stack<>();
        int i = 0;
        int crylen = cryptogram.length();
        // 중복 문자 확인
        while (i < crylen) {
            if (!stack.isEmpty()) {
                if (stack.peek() == cryptogram.charAt(i)) {
                	if (i == crylen - 1) {
                		stack.pop();
                	}
                	flag = true;
                	i++;
                    continue;
                }
                else if (flag) {
                	stack.pop();
                	flag = false;
                	continue;
                }
                else {
                	stack.push(cryptogram.charAt(i));
                	i++;
                }
            }
            else {
            	stack.push(cryptogram.charAt(i));
            	i++;
            }
            
        }
        // 간추린 문자열 생성
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
        
    }
}
