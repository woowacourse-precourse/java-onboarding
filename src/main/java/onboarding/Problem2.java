package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        Stack<Character> stk = new Stack<>();

        for(int i = 0; i < cryptogram.length(); i++) {
            Character c = cryptogram.charAt(i);
            if(!stk.isEmpty() && stk.peek() == c){
                stk.pop();
                continue;
            }
            stk.push(c);
        }

        while(!stk.isEmpty()) {
            answer = stk.peek() + answer;
            stk.pop();
        }

        return answer;
    }
}
