package onboarding;

import java.util.Stack;

public class Problem2 {
    private static Stack<Character> decodedCryptogram;
    private static char beforeChar;

    public static String solution(String cryptogram) {
        initialize();

        for (char c : cryptogram.toCharArray()) {
            decodeToBrown(c);
        }

        StringBuilder answer = new StringBuilder();
        decodedCryptogram.forEach(answer::append);

        return answer.toString();
    }

    private static void initialize() {
        decodedCryptogram = new Stack<>();
        beforeChar = ' ';
    }

    private static void decodeToBrown(char c) {
        if (beforeChar == c) {
            return;
        }

        if (decodedCryptogram.empty()) {
            decodedCryptogram.push(c);
            return;
        }

        if (decodedCryptogram.peek() == c) {
            decodedCryptogram.pop();
            beforeChar = c;
            return;
        }

        decodedCryptogram.push(c);
    }
}
