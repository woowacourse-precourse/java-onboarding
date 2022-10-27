package onboarding;

public class Problem2 {
    private static final int MINIMUM_INPUT = 1;
    private static final int MAXIMUM_INPUT = 1000;
    private static final String INPUT_ERROR = "INPUT_ERROR";

    public static String solution(String cryptogram) {
        if (isExceptionCase(cryptogram)) return INPUT_ERROR;

        if (cryptogram.length() == 1) return cryptogram;

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
        String newCrypt = "";
        char prev = ' ';

        if(cryptogram.length() < 2) return cryptogram;

        for (int i = 0; i < cryptogram.length() - 1; i++) {
            char now = cryptogram.charAt(i);
            char next = cryptogram.charAt(i + 1);
            if (now != prev && now != next) {
                newCrypt += now;
            }
            prev = now;
        }
        if (cryptogram.charAt(cryptogram.length() - 1) != cryptogram.charAt(cryptogram.length() - 2)) {
            newCrypt += cryptogram.charAt(cryptogram.length() - 1);
        }
        return newCrypt;
    }
}