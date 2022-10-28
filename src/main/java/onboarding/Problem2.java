package onboarding;

import java.util.Stack;

public class Problem2 {
    public static Stack<Character> stack;

    public static String solution(String cryptogram) {
        initStack(cryptogram);
        return deleteConsecutiveDuplicateCharacters(cryptogram);
    }

    private static void initStack(String cryptogram) {
        stack = new Stack<>();
        stack.add(cryptogram.charAt(0));
    }

    private static String deleteConsecutiveDuplicateCharacters(String cryptogram) {
        stringProcessing(cryptogram);
        return charsToString();
    }

    private static void stringProcessing(String cryptogram) {
        char storage = 0;
        for (int i = 1; i < cryptogram.length(); i++) {
            char c = cryptogram.charAt(i);
            if (c != storage) {
                if (!findDuplicatedCharactersAndPop(c)) {
                    stack.push(c);
                    storage = 0;
                } else {
                    storage = c;
                }
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