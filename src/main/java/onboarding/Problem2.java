package onboarding;

public class Problem2 {

    private static final int NONE_DUPLICATE = -1;

    public static String solution(String cryptogram) {
        while (findDuplicateStrIndex(cryptogram) != NONE_DUPLICATE) {
            int duplicateStrIndex = findDuplicateStrIndex(cryptogram);
            String newStringFront = cryptogram.substring(0, duplicateStrIndex);
            String newStringBack = cryptogram.substring(duplicateStrIndex + 2);

            cryptogram = newStringFront + newStringBack;
        }
        return cryptogram;
    }

    public static int findDuplicateStrIndex(String str) {
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                return i - 1;
            }
        }
        return NONE_DUPLICATE;
    }
}