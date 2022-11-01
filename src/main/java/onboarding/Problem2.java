package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        Stack<Character> stack = new Stack();

        for (int i = 0; i < cryptogram.length(); i++) {
            if (!stack.empty()) {
                if (stack.peek() == cryptogram.charAt(i)) {
                    stack.pop();
                } else {
                    stack.push(cryptogram.charAt(i));
                }
            } else {
                stack.push(cryptogram.charAt(i));
            }
        }

        for (int i = 0; i < stack.size(); i++) {
            answer += stack.get(i);
        }


        return answer;
    }
}
