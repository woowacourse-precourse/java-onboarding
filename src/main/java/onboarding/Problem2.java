package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;

        Stack<Character> decodedCryptogram = deleteChar(cryptogram);
        answer = convertToString(decodedCryptogram);

        return answer;
    }

    public static String convertToString(Stack<Character> stack) {
        StringBuilder result = new StringBuilder();

        for (Character c : stack) {
            result.append(c);
        }

        return result.toString();
    }

    public static Stack<Character> deleteChar(String cryptogram) {
        Stack<Character> stack = new Stack<>();

        for (char c : cryptogram.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack;
    }
}
