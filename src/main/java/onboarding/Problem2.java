package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        Stack<Character> stack = new Stack<Character>();
        int count = cryptogram.length();
        char chr;
        stack.add(cryptogram.charAt(0));
        for(int i = 1;i<count;i++){
            chr = stack.pop();
            if(cryptogram.charAt(i) != chr){
                stack.add(chr);
                stack.add(cryptogram.charAt(i));
            }
        }
        for(char i: stack){
            answer += i;
        }
        return answer;
    }
}
