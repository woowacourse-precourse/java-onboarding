package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<String> charStack = new Stack<>();
        String lastChar = null;

        for (String s : cryptogram.split("")) {
            if (!charStack.isEmpty() && charStack.peek().equals(s)) {
                lastChar = charStack.pop();
            }
            if (lastChar == null || !lastChar.equals(s)){
                charStack.push(s);
            }
        }

        StringBuilder plainText = new StringBuilder();
        for (String s : charStack) {
            plainText.append(s);
        }

        return plainText.toString();
    }
}
