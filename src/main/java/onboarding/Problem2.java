package onboarding;

import java.util.Stack;

public class Problem2 {

    public static String solution(String cryptogram) {
        return removeDuplicateCharacter(cryptogram);
    }

    /*
     주어진 문자열의 중복 문자를 제거하여 반환
     */
    public static String removeDuplicateCharacter(String cypherText) {
        Stack<Character> detectMultiple = new Stack<>();
        char[] cypherTextToCharList = cypherText.toCharArray();
        String result = "";

        for (char c : cypherTextToCharList) {
            if (detectMultiple.isEmpty()) {
                detectMultiple.add(c);
            } else if (detectMultiple.peek().equals(c)) {
                detectMultiple.pop();
            } else if (!detectMultiple.peek().equals(c)) {
                detectMultiple.add(c);
            }
        }
        while (!detectMultiple.isEmpty()) {
            result += detectMultiple.pop();
        }
        StringBuilder buffer = new StringBuilder(result);
        result = buffer.reverse().toString();
        return result;
    }
}
