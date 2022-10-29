package onboarding;

import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        int i=1;
        stack.push(cryptogram.charAt(0));

        while(!stack.isEmpty() && i<cryptogram.length()){
            if(stack.peek()==cryptogram.charAt(i)) stack.pop();
            else stack.push(cryptogram.charAt(i));
            i++;
        }

        for(char c:stack) answer+=c;

        return answer;
    }
}
