package onboarding;

import java.util.Stack;

public class Problem4 {
    public static String solution(String word) {
        if (!isOutOfRange(word)) {
            return "";
        }

        char[] chars = stringToCharArr(word);
        Stack<Character> stack = new Stack<>();

        for (char c : chars) {
            if (isAlphabet(c)) {
                if (isUpperCase(c)) {
                    stack.push(transform(c, 65));
                } else if (isLowerCase(c)) {
                    stack.push(transform(c, 97));
                }
            } else {
                stack.push(c);
            }
        }

        return getAnswer(stack);
    }

    private static boolean isOutOfRange(String word) {
        return word.length() >= 1 && word.length() <= 10000;
    }

    private static boolean isAlphabet(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private static boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private static boolean isLowerCase(char c) {
        return c >= 'a' && c <= 'z';
    }

    private static char[] stringToCharArr(String word) {
        return word.toCharArray();
    }

    private static char transform(char c, int startAscii) {
        return (char) ((startAscii * 2) + 25 - (int) c);
    }

    private static String getAnswer(Stack<Character> stack){
        StringBuilder answer = new StringBuilder();

        for (char s : stack) {
            answer.append(s);
        }
        return answer.toString();
    }
}
