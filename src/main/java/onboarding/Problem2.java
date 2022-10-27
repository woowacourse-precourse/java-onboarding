package onboarding;

import java.util.regex.Pattern;

public class Problem2 {
    static final String EXCEPTION = "[ERROR]";
    static final String REGEX = "[a-z]*$";
    static final int LENGTH_UPPERBOUND = 1000;
    static final int LENGTH_LOWERBOUND = 1;

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
        } else if (!Pattern.matches(REGEX, cryptogram)) {
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
        String newCryptogram = "";

        for (int i = 0; i < cryptogram.length(); i++) {
            if (i == 0) {
                if (cryptogram.charAt(i) != cryptogram.charAt(i + 1)) {
                    newCryptogram += cryptogram.charAt(i);
                }
            } else if (i == cryptogram.length() - 1) {
                if (cryptogram.charAt(i) != cryptogram.charAt(i - 1)) {
                    newCryptogram += cryptogram.charAt(i);
                }
            } else if (cryptogram.charAt(i) != cryptogram.charAt(i - 1) &&
                    cryptogram.charAt(i) != cryptogram.charAt(i + 1)) {
                newCryptogram += cryptogram.charAt(i);
            }
        }
        return newCryptogram;
    }
}