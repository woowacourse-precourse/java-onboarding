package onboarding;

import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        Stack<Character> stack = new Stack<>();

        for(char ch : answer.toCharArray()){
            if((!stack.empty()) && (stack.peek() == ch)){
                stack.pop();
            }
            else{
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.empty()){
            sb.append(stack.pop());
        }

        answer = sb.reverse().toString();

        return answer;
    }
}
