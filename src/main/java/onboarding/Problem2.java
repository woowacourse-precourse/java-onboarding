package onboarding;

import java.util.Iterator;
import java.util.Stack;

public class Problem2 {

    private static final char DEFAULT_VALUE = ' ';

    public static String solution(String cryptogram) {
        Stack<Character> cryptoStack = new Stack<>();
        char recentChar = DEFAULT_VALUE;


        for (char ch : cryptogram.toCharArray()) {
            if (cryptoStack.isEmpty()) {
                cryptoStack.push(ch);
                recentChar = DEFAULT_VALUE;
                continue;
            }
            if (ch == recentChar) {
                continue;
            }

            if (cryptoStack.peek() == ch) {
                recentChar = cryptoStack.pop();
                continue;
            }
            cryptoStack.push(ch);
        }
        return cryptoStack.toString();
    }
}