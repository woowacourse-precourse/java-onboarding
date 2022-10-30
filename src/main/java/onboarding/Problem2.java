package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        Stack<Character> stack = new Stack<>();
        char[] cryptogramCharArr = cryptogram.toCharArray();

        for(int i = 0; i < cryptogramCharArr.length; i++){
            if(stack.isEmpty() || stack.peek() != cryptogramCharArr[i]){
                stack.push(cryptogramCharArr[i]);
            }else{
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        answer = sb.toString();

        return answer;
    }
}
