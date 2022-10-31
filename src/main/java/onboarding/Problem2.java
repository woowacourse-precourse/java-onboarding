package onboarding;

import onboarding.problem2.Cryptogram;

import java.util.regex.Pattern;

public class Problem2 {
    static final int MAX_CRYPTO_LENGTH = 1000;
    static final int MIN_CRYPTO_LENGTH = 1;
    public static String solution(String cryptogram) {
        if (!validateCryptogram(cryptogram)) {
            return null;
        }

        return Cryptogram.decryptCryptogram(cryptogram);
    }

    public static boolean validateCryptogram(String cryptogram) {
        if (cryptogram.length() < MIN_CRYPTO_LENGTH || cryptogram.length() > MAX_CRYPTO_LENGTH) {
            return false;
        }
        String pattern = "^[a-z]*$";
        return Pattern.matches(pattern, cryptogram);
    }
}
