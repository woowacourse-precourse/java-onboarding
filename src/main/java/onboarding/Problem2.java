package onboarding;

public class Problem2 {

    private static final String REGEX_LOWER_ALPHABET = "([a-z])\\1";
    private static final String SPACE = "";
    private static final int MAX_CRYPTOGRAM_LENGTH = 1000;

    public static String solution(String cryptogram) {
        String decrypting = SPACE;
        String beforeTryedDecrypting = SPACE;

        decrypting = cryptogram.replaceAll(REGEX_LOWER_ALPHABET, SPACE);

        for (int i = 0; i < MAX_CRYPTOGRAM_LENGTH; i++) {
            beforeTryedDecrypting = decrypting;
        }

        return decrypting;
    }
}
