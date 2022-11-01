package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Problem2 {
    private static Stack<Character> decodedCryptogram;

    public static String solution(String cryptogram) {
        decodedCryptogram = new Stack<>();
        for (char arg : cryptogram.toCharArray()) {
            decoding(arg);
        }
        StringBuilder answer = new StringBuilder();
        decodedCryptogram.forEach(answer::append);
        return answer.toString();
    }

    private static void decoding(char arg) {
        if (decodedCryptogram.empty()) {
            decodedCryptogram.push(arg);
            return;
        }
        Character peekBefore = decodedCryptogram.peek();
        if (peekBefore == arg) {
            decodedCryptogram.pop();
            return;
        } else if (peekBefore != arg) {
            decodedCryptogram.push(arg);
            return;
        }

    }

}