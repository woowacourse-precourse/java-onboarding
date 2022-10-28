package onboarding;

public class Problem2 {
    private static final int MINIMUM_INPUT = 1;
    private static final int MAXIMUM_INPUT = 1000;
    private static final String INPUT_ERROR = "INPUT_ERROR";
    private static final String PATTERN = "(\\w)\\1{1,}";

    public static String solution(String cryptogram) {
        if (isExceptionCase(cryptogram)) return INPUT_ERROR;

        while (true) {
            String decoded = decodeCryptogram(cryptogram);
            if (cryptogram.equals(decoded)) break;
            cryptogram = decoded;
        }
        return cryptogram;
    }

    private static boolean isExceptionCase(String cryptogram) {
        if (cryptogram.length() < MINIMUM_INPUT || cryptogram.length() > MAXIMUM_INPUT) return true;
        return !cryptogram.equals(cryptogram.toLowerCase());
    }

    private static String decodeCryptogram(String cryptogram) {
        return cryptogram.replaceAll(PATTERN, "");
    }
}