package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        char [] temp = cryptogram.toCharArray();
        boolean isConverting = true;

        while(isConverting){
            boolean check = false;
            Stack<Character> stack = new Stack<>();

            for(char c : temp){
                if(!stack.isEmpty() && stack.peek() == c){
                    stack.pop();
                    check = true;
                }else
                    stack.push(c);
            }

            StringBuilder sb = new StringBuilder();
            for(Character c : stack){
                sb.append(c);
            }
            answer = sb.toString();
            temp = sb.toString().toCharArray();
            isConverting = check;
        }

        return answer;
    }
}
