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
    private static String decodeCryptogram(String cryptogram) {
        Stack<Character> decodeStack = new Stack<>();
        for (int i = 0; i < cryptogram.length(); i++) {
            char letter = cryptogram.charAt(i);
            decodeProcess(decodeStack, letter);
        }
        return stackToString(decodeStack);
    }
    public static String solution(String cryptogram) {
        String answer = decodeCryptogram(cryptogram);
        return answer;
    }
}
