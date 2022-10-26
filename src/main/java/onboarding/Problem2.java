package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        int N = cryptogram.length();

        while (i < N){
            String next = Character.toString(cryptogram.charAt(i));
            if (stack.empty()) {
                stack.push(next);
                i += 1;
            } else if (stack.peek().equals(next)){
                stack.pop();
                i += 1;
            } else {
                stack.push(next);
                i += 1;
            }
        }
        String answer = "";
        for (String s:stack){
            answer = answer + s;
        }
        return answer;
    }
}
