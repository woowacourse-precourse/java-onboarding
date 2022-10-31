package onboarding;

import java.util.ArrayList;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        char[] check = cryptogram.toCharArray();
        Stack<Character> stack = new Stack<>();

        stack.push(check[0]);
        for (int i = 1; i < check.length; i++) {
            if(check[i] == stack.peek()){
                stack.pop();
            }else{
                stack.push(check[i]);
            }
        }

        char[] password = new char[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            password[i] = stack.get(i);
        }

        String answer = String.valueOf(password);

        return answer;
    }
}
