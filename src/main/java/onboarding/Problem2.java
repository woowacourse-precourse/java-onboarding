package onboarding;

import java.util.Stack;

public class Problem2 {
    private static void decodeProcess(Stack<Character> decodeStack, char letter) {
        if (!decodeStack.isEmpty() && decodeStack.peek() == letter) {
            decodeStack.pop();
            return;
        }
        decodeStack.push(letter);
    }
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
