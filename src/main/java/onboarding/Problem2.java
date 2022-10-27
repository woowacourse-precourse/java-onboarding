package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < cryptogram.length(); i++) {
            if(!stack.empty() && cryptogram.charAt(stack.peek()) == cryptogram.charAt(i)) {
                while(i < cryptogram.length() && cryptogram.charAt(stack.peek()) == cryptogram.charAt(i)) i++;
                stack.pop();
                i--;
                continue;
            }
            stack.push(i);
        }

        StringBuilder answer = new StringBuilder();
        for (Integer i : stack) answer.append(cryptogram.charAt(i));

        return answer.toString();
    }
}
