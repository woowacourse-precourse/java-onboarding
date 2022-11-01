package onboarding;

public class Problem2 {
    private static final String REGEX = "([a-z])\\1+";
    private static final String EMPTY_STRING = "";

    public static String solution(String cryptogram) {
        return decodeCryptogram(cryptogram);
    }

    private static String decodeCryptogram(String cryptogram) {
        String decodedCryptogram = cryptogram;
        do {
            cryptogram = decodedCryptogram;
            decodedCryptogram = removeConsecutiveDuplicates(cryptogram);
        } while (!isCompletedDecoding(cryptogram, decodedCryptogram));
        return decodedCryptogram;
    }

    private static String removeConsecutiveDuplicates(String cryptogram) {
        return cryptogram.replaceAll(REGEX, EMPTY_STRING);
    }

    private static boolean isCompletedDecoding(String cryptogram, String decodedCryptogram) {
        return cryptogram.equals(decodedCryptogram);
    }
}
