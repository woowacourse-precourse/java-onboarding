package onboarding;

import java.util.Stack;
import java.lang.StringBuffer;

public class Problem2 {
    public static String erase(String s) {
        Stack<Character> stack = new Stack<>();
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            }
            else{
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            temp += stack.pop();
        }
        StringBuffer sb = new StringBuffer(temp);
        String res = sb.reverse().toString();
        return res;
    }
    public static String solution(String cryptogram) {
        String answer = erase(cryptogram);
        return answer;
    }
}
