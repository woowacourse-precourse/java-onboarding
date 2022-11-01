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
    private static String stackToString(Stack<Character> decodeStack) {
        String answer = "";
        while (!decodeStack.isEmpty()) {
            answer = decodeStack.pop() + answer;
        }
        return answer;
    }
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
