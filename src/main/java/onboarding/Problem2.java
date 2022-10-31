package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        char top, now;

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < cryptogram.length(); i++) {
            now = cryptogram.charAt(i);
            if(stack.empty()) {
                stack.push(now);
                continue;
            }
            top = stack.peek();
            if(top == now) {
                stack.pop();
            }
            else{
                stack.push(now);
            }
        }

        while(!stack.empty()) {
            sb.append(stack.pop());
        }
        sb.reverse();

        answer = sb.toString();

        return answer;
    }
}
