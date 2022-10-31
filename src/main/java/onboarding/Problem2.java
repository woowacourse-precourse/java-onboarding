package onboarding;

import java.util.Stack;

public class Problem2 {

    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        char temp = 0;

        for(char ch : cryptogram.toCharArray()) {
            if(stack.empty()) {
                stack.push(ch);
                continue;
            }
            if(stack.peek() == ch) {
                temp = ch;
                continue;
            }
            if(stack.peek() == temp) {
                while (!stack.empty() && stack.peek() == temp) {
                    stack.pop();
                }
                if(!stack.empty())
                    temp = stack.peek();
            }
            stack.push(ch);
        }

        while (!stack.empty() && stack.peek() == temp) {
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        for(char c : stack)
            sb.append(c);

        return sb.toString();
    }
}
