package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = toString(getPlainText(cryptogram));
        return answer;
    }

    private static StringBuilder toStringBuilder(String cryptogram) {
        StringBuilder stringBuilder = new StringBuilder(cryptogram);
        return stringBuilder;
    }

    public static boolean isDuplicate(StringBuilder cryptogram, int index) {
        if (cryptogram.charAt(index) == cryptogram.charAt(index + 1)) {
            return true;
        }
        return false;
    }

    public static boolean isDuplicateFullRange(StringBuilder cryptogram) {
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (isDuplicate(cryptogram, i)) {
                return true;
            }
        }
        return false;
    }

    public static int getDuplicateRange(StringBuilder cryptogram, int start) {
        int range = 1;
        for (int i = start; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                range += 1;
            }
            if (cryptogram.charAt(i) != cryptogram.charAt(i + 1)) {
                break;
            }
        }
        return range;
    }

    public static void removeDuplicate(StringBuilder cryptogram, int start, int range) {
        cryptogram.delete(start, start + range);
    }

    public static void decrypt(StringBuilder stringBuilderCryptogram) {
        for (int i = 0; i < stringBuilderCryptogram.length() - 1; i++) {
            if (isDuplicate(stringBuilderCryptogram, i)) {
                int range = getDuplicateRange(stringBuilderCryptogram, i);
                removeDuplicate(stringBuilderCryptogram, i, range);
            }
        }
    }

    public static StringBuilder getPlainText(String cryptogram) {
        StringBuilder plainText = toStringBuilder(cryptogram);
        do {
            decrypt(plainText);
        } while (isDuplicateFullRange(plainText));
        return plainText;
    }

    private static String toString(StringBuilder stringBuilderCryptogram) {
        return stringBuilderCryptogram.toString();
    }
}
