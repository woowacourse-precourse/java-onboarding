package onboarding;

import java.util.Stack;

public class Problem2 {
    public static Stack<Character> stack;

    public static String solution(String cryptogram) {
        stack = new Stack<>();
        return deleteConsecutiveDuplicateCharacters(cryptogram);
    }

    private static String deleteConsecutiveDuplicateCharacters(String cryptogram) {
        stringProcessing(cryptogram);
        return charsToString();
    }

    private static void stringProcessing(String cryptogram) {
        for (int i = 0; i < cryptogram.length(); i++) {
            char c = cryptogram.charAt(i);
            if (i != 0) {
                if (!findDuplicatedCharactersAndPop(c)) {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
    }

    private static boolean findDuplicatedCharactersAndPop(char c) {
        if (stack.peek() == c) {
            stack.pop();
            return true;
        } else {
            return false;
        }
    }

    private static String charsToString() {
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}