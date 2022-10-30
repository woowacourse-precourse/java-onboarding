package onboarding;

import java.util.Stack;

/*
기능목록
1. 중복되는 문자 제거 (1회전만)
2. 중복이 없어질때까지 중복 문자 제거
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        Stack<Character> stack=new Stack<>();

        char duplication=cryptogram.charAt(0); //중복된 문자
        stack.push(cryptogram.charAt(0));
        for(int i=1; i<cryptogram.length(); i++){
            char c=cryptogram.charAt(i);
            if(duplication!=c){
                stack.push(c);
                duplication=c;
            }else{
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
        }
        for(char c: stack){
            answer+=c;
        }
        return answer;
    }
}
