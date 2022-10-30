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
        char duplication='\u0000'; //중복된 문자
        for(int i=0; i<cryptogram.length(); i++){
            char c=cryptogram.charAt(i);
            if(stack.isEmpty()){
                if(duplication==c) continue;
                stack.push(c);
            }else{
                if(stack.peek()==c || duplication==c){
                    stack.pop();
                    duplication=c;
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
