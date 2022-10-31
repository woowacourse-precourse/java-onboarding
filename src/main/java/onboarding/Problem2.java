package onboarding;

import java.util.Stack;

public class Problem2 {
    private static Stack<Character> reduceStringByStack(String cryptogram){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < cryptogram.length(); i++){
            if(!stack.empty() && stack.peek() == cryptogram.charAt(i))
                stack.pop();
            else
                stack.push(cryptogram.charAt(i));
        }
        return stack;
    }


    public static String solution(String cryptogram) {
        Stack<Character> stack = reduceStringByStack(cryptogram);
        return "";
    }
}
