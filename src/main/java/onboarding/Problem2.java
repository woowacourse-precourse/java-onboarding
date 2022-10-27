package onboarding;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
    private static final int MIN_CRYPTOGRAM_LENGTH = 1;
    private static final int MAX_CRYPTOGRAM_LENGTH = 1000;

    public static String solution(String cryptogram) {
        String answer = "answer";

        if (!isValidCryptogram(cryptogram)) {
            throw new IllegalArgumentException("문자열의 형태가 유효하지 않습니다");
        }

        Stack<Character> unduplicatedCryptogram = removeDupAdjacentChar(cryptogram);

        return answer;
    }

    public static boolean isValidCryptogram(String cryptogram) {
        String uppercaseRegEx = "[A-Z]";
        Pattern uppercasePattern = Pattern.compile(uppercaseRegEx);
        Matcher uppercase = uppercasePattern.matcher(cryptogram);

        if (cryptogram.length() < MIN_CRYPTOGRAM_LENGTH || cryptogram.length() > MAX_CRYPTOGRAM_LENGTH || uppercase.find()) {
            return false;
        }

        return true;
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
}
