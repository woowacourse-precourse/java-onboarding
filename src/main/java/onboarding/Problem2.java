package onboarding;

import java.util.Objects;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        Stack<Character> stk = new Stack<>();
        stk.push(cryptogram.charAt(0));
        for(int i=1;i<cryptogram.length();i++){
            char tmp = stk.pop();
            if(tmp != cryptogram.charAt(i)){
                stk.push(tmp);
                stk.push(cryptogram.charAt(i));
            }
        }
        while(!stk.empty()){
            answer+=stk.pop();
        }
        StringBuffer sb = new StringBuffer(answer);
        answer = sb.reverse().toString();
        return answer;
    }
}
