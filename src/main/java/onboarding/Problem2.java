package onboarding;

import onboarding.problem2.Cryptogram;

import java.util.regex.Pattern;

public class Problem2 {
    public static String solution(String cryptogram) {
        if (!validateCryptogram(cryptogram)) {
            return null;
        }

        return Cryptogram.decryptCryptogram(cryptogram);
    }

    public static boolean validateCryptogram(String cryptogram) {
        if (cryptogram.length() < 1 || cryptogram.length() > 1000) {
            return false;
        }
        String pattern = "^[a-z]*$";
        return Pattern.matches(pattern, cryptogram);
    }
}
