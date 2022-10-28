package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String preProcessed = cryptogram;
        String postProcessed = process(preProcessed);
        while (!preProcessed.equals(postProcessed)) {
            preProcessed = postProcessed;
            postProcessed = process(preProcessed);
        }

        return postProcessed;
    }

    static String process(String str){
        Stack<Character> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();

        for(char x : str.toCharArray()) {
            if(stack.isEmpty()) {stack.push(x); continue;}
            if(stack.peek() == x) {stack.push(x); continue;}
            if(stack.peek() != x) {
                if(stack.size()==1) stringBuilder.append(stack.pop());
                else stack.clear();
                stack.push(x);
            }
        }
        if (stack.size()==1) stringBuilder.append(stack.pop());

        return stringBuilder.toString();
    }
}
