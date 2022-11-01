package onboarding;

import java.util.ArrayList;
import java.util.Stack;

public class Problem2 {
    public static Stack<String> cryptogramStack;

    public static String solution(String cryptogram) {
        StringBuilder sb = new StringBuilder();
        stringToDecode(cryptogram);

        cryptogramStack.stream().forEach(sb::append);

        return sb.toString();
    }
    private static void stringToDecode(String cryptogram) {
        cryptogramStack = new Stack<>();
        for (String s : cryptogram.split("")) {
            decode(s);
        }
    }
    private static void decode(String s) {
        String top = cryptogramStack.peek();

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
