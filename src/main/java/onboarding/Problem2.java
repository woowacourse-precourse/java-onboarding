package onboarding;

import java.util.ArrayList;
import java.util.Stack;

public class Problem2 {
    public static Stack<Character> cryptogramStack;

    public static String solution(String cryptogram) {
        cryptogramStack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        stringToDecode(cryptogram);
        cryptogramStack.stream().forEach(sb::append);

        return sb.toString();
    }

    private static void stringToDecode(String cryptogram) {
        for (char s : cryptogram.toCharArray()) {
            decode(s);
        }
    }

    private static void decode(char s) {
        Character top = cryptogramStack.peek();
        if (cryptogramStack.empty()) {
            cryptogramStack.push(s);
            return;
        }
        if (top == s) {
            cryptogramStack.pop();
            return;
        }
        cryptogramStack.push(s);
    }
}
