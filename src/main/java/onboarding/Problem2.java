package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        //Check the peek in order
        //If input value is equal to peek then pop else push
        cryptogram.chars().forEach(i -> {
            if (!stack.isEmpty() && stack.peek() == i) {
                stack.pop();
            } else
                stack.push((char) i);
        });

        for(int i = 0; i < stack.size(); ++i) {
            answer += stack.get(i);
        }

        return answer;
    }
}
