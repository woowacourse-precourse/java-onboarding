package onboarding;

import java.util.Stack;
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

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
        }
        return answer;
    }
}
