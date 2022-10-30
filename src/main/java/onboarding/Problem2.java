package onboarding;

import java.util.Stack;

/*
기능목록
1. 2개씩 중복되는 경우 제거하는 기능
2. 중복이 3개이상일 경우 제거하는 기능
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        Stack<Character> stack=new Stack<>();

        for(int i=0; i<cryptogram.length(); i++){
            char c=cryptogram.charAt(i);
            if(stack.isEmpty()){
                stack.push(c);
            }else{
                if(stack.peek()==c){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
        }
        for (Character c : stack){
            answer+=c;
        }
        return answer;
    }
}
