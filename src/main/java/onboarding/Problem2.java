package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        String answer = "";

        for(char c : cryptogram.toCharArray())
        {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }

        for(char c : stack) {
            answer += c;
        }

        return answer;
    }
}
