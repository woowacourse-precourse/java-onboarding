package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {

        Stack<String> charStack = getPlainText(cryptogram);

        String plainText = String.join("", charStack);

        return plainText;
    }

    private static Stack<String> getPlainText(String cryptogram) {
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

        return charStack;
    }
}
