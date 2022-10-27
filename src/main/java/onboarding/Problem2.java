package onboarding;

import java.util.regex.Pattern;

public class Problem2 {
    static final String EXCEPTION = "[ERROR]";
    static final String VALIDATION_REGEX = "[a-z]*$";
    static final int LENGTH_UPPERBOUND = 1000;
    static final int LENGTH_LOWERBOUND = 1;
    static final char SENTINEL = '#';
    public static String solution(String cryptogram) {
        if (validationCheck(cryptogram)) {
            while (needToCompress(cryptogram)) {
                cryptogram = doCompress(cryptogram);
            }
            return cryptogram;
        }
        return EXCEPTION;
    }

    public static boolean validationCheck(String cryptogram) {
        if (cryptogram.length() > LENGTH_UPPERBOUND || cryptogram.length() < LENGTH_LOWERBOUND) {
            return false;
        } else if (!Pattern.matches(VALIDATION_REGEX, cryptogram)) {
            return false;
        }
        return true;
    }
    public static boolean needToCompress(String cryptogram) {
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                return true;
            }
        }
        return false;
    }

    public static String doCompress(String cryptogram) {
        String newCryptogram = SENTINEL + cryptogram + SENTINEL;
        String result = "";
        for (int i = 1; i < newCryptogram.length() - 1; i++) {
            char leftValue = newCryptogram.charAt(i-1);
            char middleValue = newCryptogram.charAt(i);
            char rightValue = newCryptogram.charAt(i+1);

            if (leftValue != middleValue && middleValue != rightValue) {
                result += middleValue;
            }
        }
        return result;
    }
}