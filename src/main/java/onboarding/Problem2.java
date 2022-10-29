package onboarding;

public class Problem2 {
    private static final String PATTERN = "([a-z])\\1{1,}";
    private static final String SPACE = "";

    public static String solution(String cryptogram) {
        String before = SPACE;
        while (canRemove(cryptogram, before)) {
            before = cryptogram;
            cryptogram = removeConsecutiveStrings(cryptogram);
        }
        return cryptogram;
    }

    private static boolean canRemove(String cryptogram, String before) {
        return !cryptogram.equals(before);
    }

    private static String removeConsecutiveStrings(String cryptogram) {
        return cryptogram.replaceAll(PATTERN, SPACE);
    }
}
