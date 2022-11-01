package onboarding;

public class Problem2 {

    private static final String REGEX_LOWER_ALPHABET = "([a-z])\\1";
    private static final String SPACE = "";

    public static String solution(String cryptogram) {
        String decrypting = SPACE;
        String beforeTryedDecrypting = SPACE;

        decrypting = cryptogram.replaceAll(REGEX_LOWER_ALPHABET, SPACE);
        return decrypting;
    }
}
