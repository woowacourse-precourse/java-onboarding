package onboarding;

import java.util.regex.Pattern;

public class Problem2 {

    public static String solution(String cryptogram) {

        if (isNotValidateCryptogram(cryptogram)) {
            throw new IllegalArgumentException();
        }

        Pattern pattern = Pattern.compile("([a-z])\\1+");
        while (pattern.matcher(cryptogram).find()) {
            cryptogram = cryptogram.replaceFirst("([a-z])\\1+", "");
        }

        return cryptogram;
    }

    private static boolean isNotValidateCryptogram(String cryptogram) {

        int length = cryptogram.length();
        if (length < 1 || length > 1000) {
            return true;
        }

        for (int i = 0; i < length; i++) {
            char c = cryptogram.charAt(i);

            if (!Character.isLowerCase(c)) {
                return true;
            }
        }

        return false;
    }
}
