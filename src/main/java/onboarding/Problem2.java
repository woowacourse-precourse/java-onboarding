package onboarding;

import java.util.Stack;

public class Problem2 {

    public static String solution(String cryptogram) {

        Stack<Character> stack = new Stack<>();
        char temp = ' ';
        if (cryptogram.equals("")) {
            return "";
        }
        for (int i = 0; i < cryptogram.length(); i++) {
            if (!stack.isEmpty() && cryptogram.charAt(i) == stack.peek()) {
                temp = stack.pop();
            } else {
                if (cryptogram.charAt(i) != temp) {
                    temp = cryptogram.charAt(i);
                    stack.push(cryptogram.charAt(i));
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        for (char ch : stack) {
            answer.append(ch);
        }
        return String.valueOf(answer);
    }

}