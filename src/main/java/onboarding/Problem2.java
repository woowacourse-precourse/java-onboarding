package onboarding;

import java.util.Stack;

public class Problem2 {
    private static Stack<Character> decodedCryptogram;

    public static String solution(String cryptogram) {
        decodedCryptogram = new Stack<>();
        for (char c : cryptogram.toCharArray()) {
            decodeToBrown(c);
        }

        StringBuilder answer = new StringBuilder();
        decodedCryptogram.forEach(answer::append);

        return answer.toString();
    }

    private static void decodeToBrown(char c) {
        if (decodedCryptogram.empty()) {
            decodedCryptogram.push(c);
            return;
        }

        Character before = decodedCryptogram.peek();
        if (before == c) {
            decodedCryptogram.pop();
            return;
        }

        decodedCryptogram.push(c);
    }
}
