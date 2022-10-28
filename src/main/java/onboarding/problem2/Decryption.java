package onboarding.problem2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Decryption {
    public static final String REPEAT_PATTERN = "([a-z])\\1+";

    private static String removeRepeatedCharacters(String cryptogram) {
        return cryptogram.replaceAll(REPEAT_PATTERN, "");
    }

    private static boolean hasNotRepeatedCharacters(String cryptogram, Pattern pattern) {
        Matcher cryptogramMatcher = pattern.matcher(cryptogram);
        return !cryptogramMatcher.find();
    }
}
