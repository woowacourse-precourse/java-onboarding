package onboarding.problem2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Decryption {
    public static final String REPEAT_PATTERN_REGEXP = "([a-z])\\1+";

    public static String decrypt(String cryptogram) {
        boolean decryptionComplete = false;
        Pattern repeatPattern = Pattern.compile(REPEAT_PATTERN_REGEXP);
        while (!decryptionComplete) {
            cryptogram = removeRepeatedCharacters(cryptogram);
            decryptionComplete = hasNotRepeatedCharacters(cryptogram, repeatPattern);
        }
        return cryptogram;
    }

    private static String removeRepeatedCharacters(String cryptogram) {
        return cryptogram.replaceAll(REPEAT_PATTERN_REGEXP, "");
    }

    private static boolean hasNotRepeatedCharacters(String cryptogram, Pattern pattern) {
        Matcher cryptogramMatcher = pattern.matcher(cryptogram);
        return !cryptogramMatcher.find();
    }
}
