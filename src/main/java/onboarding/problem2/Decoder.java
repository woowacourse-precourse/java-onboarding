package onboarding.problem2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Decoder {

    private static final String REGEX_STRING = "(([a-z])\\2+)";
    private static final Pattern REGEX_PATTERN = Pattern.compile("(([a-z])\\2+)");

    private Decoder() {
    }

    public static String decode(String cryptogram) {
        validateCryptogram(cryptogram);

        while (hasDuplicates(cryptogram)) {
            cryptogram = deleteDuplicates(cryptogram);
        }
        return cryptogram;
    }

    private static boolean hasDuplicates(String cryptogram) {
        Matcher matcher = REGEX_PATTERN.matcher(cryptogram);
        return matcher.find();
    }

    private static String deleteDuplicates(String cryptogram) {
        return cryptogram.replaceAll(REGEX_STRING, "");
    }

    private static void validateCryptogram(String cryptogram) {
        if (cryptogram.length() < 1 || cryptogram.length() > 1000) {
            throw new RuntimeException("cryptogram 은 1 이상 1000 이하의 길이만 사용 가능합니다.");
        }
        if (!cryptogram.matches("^[a-z]*$")) {
            throw new RuntimeException("cryptogram 은 소문자만 사용 가능합니다.");
        }
    }
}
