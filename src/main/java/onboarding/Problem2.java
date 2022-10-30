package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        String copy = cryptogram;
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (isCharsDuplicatedInGivenIdx(cryptogram, i)) {
                cryptogram = deleteTwoCharsFromIdx(cryptogram, i);
            }
        }
        if (cryptogram.equals(copy)) {
            return cryptogram;
        }
        return solution(cryptogram);
    }

    public static boolean isCharsDuplicatedInGivenIdx(String string, int idx) {
        if (string.charAt(idx) == string.charAt(idx + 1)) {
            return true;
        }
        return false;
    }

    public static String deleteTwoCharsFromIdx(String string, int idx) {
        String prefix = string.substring(0, idx);
        String suffix = string.substring(idx + 2, string.length());
        return prefix + suffix;
    }
}
