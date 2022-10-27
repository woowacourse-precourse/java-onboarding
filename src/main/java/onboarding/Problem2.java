package onboarding;

import java.util.Stack;

/**
 * 기능 요구사항
 * 1. 중복된 문자열을 삭제하는 기능을 구현한다.
 */
public class Problem2 {
    static Stack<Character> stack;
    public static String solution(String cryptogram) {
        StringBuilder answer = new StringBuilder();
        stack = new Stack<>();
        removeDuplicates(cryptogram);

        for(char c : stack) answer.append(c);
        return answer.toString();
    }

    public static void removeDuplicates(String cryptogram){
        stack.push(cryptogram.charAt(0));
        for(int i=1;i<cryptogram.length();i++){
            char word = cryptogram.charAt(i);
            if(stack.peek()==word){
                stack.pop();
            }else{
                stack.push(word);
            }
        }
    }
}
