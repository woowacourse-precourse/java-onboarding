package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {

        Stack<Character> stk = new Stack<>();
        boolean flag = false;
        for (int i=0; i < cryptogram.length(); i++){
            if (stk.empty()) {
                stk.push(cryptogram.charAt(i));
            }
            else {
                if (stk.peek() == cryptogram.charAt(i)) {
                    flag = true;
                }
                else if (flag){
                    flag = false;
                    stk.pop();
                    if (stk.peek() == cryptogram.charAt(i)){
                        flag = true;
                    }
                    else {
                        stk.push(cryptogram.charAt(i));    
                    }
                }
                else {
                    stk.push(cryptogram.charAt(i));
                    
                }
            }
        }
        if (flag) {
            stk.pop();
        }

        String answer = "";
        while (!stk.empty()) {
            answer = stk.pop() + answer;
        }
        return answer;
    }
}
