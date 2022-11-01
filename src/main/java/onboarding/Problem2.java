package onboarding;

import java.util.Stack;
public class Problem2 {
    public static String solution(String cryptogram) {

        Stack<Character> stack = new Stack<>();
        char[] charCryptogram = cryptogram.toCharArray();
        char deletedChar = ' ';

        for (char nowChar : charCryptogram) {

            if (stack.isEmpty()) {
                stack.add(nowChar);
                continue;
            }

            char beforeChar = stack.peek();
            if (nowChar == beforeChar) {
                stack.pop();
                deletedChar = nowChar;
                continue;
            }
            if (nowChar == deletedChar) {
                continue;
            }

            stack.add(nowChar);
            deletedChar = ' ';
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
