package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i<cryptogram.length(); i++) {
            char nowChar = cryptogram.charAt(i);
            if (stack.isEmpty() == true) {
                stack.push(nowChar);
            } else {
                if (stack.peek() == nowChar) {
                    stack.pop();
                } else {
                    stack.push(nowChar);
                }
            }
        }

        for (char leftChar : stack) {
            answer += leftChar;
        }

        return answer;
    }
}
