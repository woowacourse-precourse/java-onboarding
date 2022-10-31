package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<Character>();
        for(char c : cryptogram.toCharArray()){
            if(stack.empty()) stack.push(c);
            else if(stack.peek() != c) stack.push(c);
            else{
                while(stack.peek() != c) stack.pop();
            }
        }
        return null;
    }
}
