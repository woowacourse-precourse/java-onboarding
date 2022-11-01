package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < cryptogram.length(); i++) {
            if (stack.isEmpty())
                stack.push(cryptogram.charAt(i));
            else if (stack.lastElement() == cryptogram.charAt(i))
                stack.pop();
            else
                stack.push(cryptogram.charAt(i));
        }
        String temp = "";
        for (Character character : stack) {
            temp += character;
        }
        answer = temp;
        return answer;
    }
}
