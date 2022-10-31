package onboarding;

import onboarding.problem2.CryptogramException;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        CryptogramException.checkException(cryptogram);

        Stack<Character> decodedStack = decodeCryptogram(cryptogram);
        return makeStackToString(decodedStack);
    }

    private static Stack<Character> decodeCryptogram(String cryptogram) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < cryptogram.length(); i++) {
            if (!stack.empty() && cryptogram.charAt(i) == stack.peek()) {
                stack.pop();
            }else {
                stack.push(cryptogram.charAt(i));
            }
        }
        return stack;
    }

    private static String makeStackToString(Stack<Character> stack) {
        int size = stack.size();
        String[] letterArray = new String[size];
        size--;

        while (!stack.empty()) {
            char letter = stack.pop();
            letterArray[size--] = String.valueOf(letter);
        }
        return String.join("", letterArray);
    }
}
