package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        while (hasDuplicatedChar(cryptogram)) {
            boolean[] isDuplicatedChar = checkDuplicatedChar(cryptogram);
            cryptogram = concatNotDeletedChars(cryptogram, isDuplicatedChar);
        }
        return cryptogram;
    }
    private static boolean hasDuplicatedChar(String cryptogram) {
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1))
                return true;
        }
        return false;
    }
    private static boolean[] checkDuplicatedChar(String cryptogram) {
        int len = cryptogram.length();
        boolean[] isDuplicatedChar = new boolean[len];

        for (int i = 0; i < len - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                isDuplicatedChar[i] = true;
                isDuplicatedChar[i + 1] = true;
            }
        }
        return isDuplicatedChar;
    }
    private static String concatNotDeletedChars(String cryptogram, boolean[] isDuplicatedChar) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cryptogram.length(); i++) {
            if (!isDuplicatedChar[i])
                sb.append(cryptogram.charAt(i));
        }
        return sb.toString();
    }
}