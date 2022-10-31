package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        boolean[] isDeleted;
        boolean isDuplicated = true;
        StringBuilder stringBuilder = new StringBuilder(cryptogram);
        while (isDuplicated) {
            if (isShort(cryptogram)) {
                return cryptogram;
            }
            isDeleted = new boolean[cryptogram.length()];
            isDuplicated = isDuplicated(cryptogram, isDeleted);
            cryptogram = getCryptogram(cryptogram, isDeleted, isDuplicated, stringBuilder);
        }
        return cryptogram;
    }

    private static String getCryptogram(String cryptogram, boolean[] isDeleted, boolean isDuplicated,
        StringBuilder stringBuilder) {
        if (isDuplicated) {
            cryptogram = deleteDuplicates(cryptogram, isDeleted, stringBuilder);
        }
        return cryptogram;
    }

    private static String deleteDuplicates(String cryptogram, boolean[] isDeleted, StringBuilder stringBuilder) {
        stringBuilder.setLength(0);
        for (int i = 0; i < cryptogram.length(); i++) {
            if (!isDeleted[i]) {
                stringBuilder.append(cryptogram.charAt(i));
            }
        }
        cryptogram = stringBuilder.toString();
        return cryptogram;
    }

    private static boolean isShort(String cryptogram) {
        return cryptogram.length() <= 1;
    }

    private static boolean isDuplicated(String cryptogram, boolean[] isDeleted) {
        boolean isDuplicated = false;
        char previous = cryptogram.charAt(0);
        for (int i = 1; i < cryptogram.length(); i++) {
            char current = cryptogram.charAt(i);
            if (isSame(previous, current)) {
                isDeleted[i - 1] = true;
                isDeleted[i] = true;
                isDuplicated = true;
            }
            previous = current;
        }
        return isDuplicated;
    }

    private static boolean isSame(char previous, char current) {
        return previous == current;
    }
}
