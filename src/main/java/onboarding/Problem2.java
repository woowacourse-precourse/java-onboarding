package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> charStack = new Stack<>();
        for (int i = 0; i < cryptogram.length(); i++) {
            char nowChar = cryptogram.charAt(i);
            if (charStack.empty() || !charStack.peek().equals(nowChar)) {
                charStack.push(nowChar);
            } else {
                while(i + 1 < cryptogram.length() &&
                        charStack.peek().equals(cryptogram.charAt(i + 1))){
                    i++;
                }
                charStack.pop();
            }
        }

        return charStack.stream()
                .map(Object::toString)
                .reduce("", (a, b) -> a + b);
    }
}
