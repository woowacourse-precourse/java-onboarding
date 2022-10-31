package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> duplication_stack = changeToStack(cryptogram);
        String answer = "answer";
        return answer;
    }
    static Stack<Character> changeToStack(String cryptogram){
        Stack<Character> temp_stack = new Stack<Character>();
        for(int i=0; i<cryptogram.length(); i++){
            temp_stack.push(cryptogram.charAt(i));
        }
        return temp_stack;
    }
}