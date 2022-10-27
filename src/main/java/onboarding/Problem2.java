package onboarding;

import java.util.Stack;

public class Problem2 {

    public static String solution(String cryptogram) {
        String result = "";
        char temp = ' ';

        Stack<Character> stack = new Stack<>();
        for (char c : cryptogram.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            }
            else if (temp == c){
                continue;
            }
            else if (stack.peek() != c) {
                stack.add(c);
            }
            temp = c;
        }
        return result;
    }
}
