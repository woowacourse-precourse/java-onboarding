package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        return decryption(cryptogram);
    }

    private static String decryption(String cipher) {
        char[] cipherText = cipher.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (Character character: cipherText) {
            if(stack.isEmpty()) {
                stack.push(character);
                continue;
            }
            if (character == stack.lastElement()) {
                stack.pop();
                continue;
            }
            stack.push(character);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Character character: stack) {
            stringBuilder.append(character);
        }

        return stringBuilder.toString();
    }
}
