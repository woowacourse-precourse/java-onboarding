package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer;

        Stack<Character> unduplicatedCryptogram = removeDupAdjacentChar(cryptogram);
        answer = convertStacktoString(unduplicatedCryptogram);

        return answer;
    }

    public static Stack<Character> removeDupAdjacentChar(String cryptogram) {
        Stack<Character> storage = new Stack<>();
        int idx = 0;

        while (idx < cryptogram.length()) {
            char charOfCryptogram = cryptogram.charAt(idx);

            if (!storage.isEmpty() && storage.peek() == charOfCryptogram) {
                storage.pop();
            } else {
                storage.push(charOfCryptogram);
            }

            idx++;
        }

        return storage;
    }

    public static String convertStacktoString(Stack<Character> charStack) {
        StringBuilder newString = new StringBuilder();
        String result;

        while (!charStack.isEmpty()) {
            newString.append(charStack.pop());
        }

        result = newString.reverse().toString();

        return result;
    }
}