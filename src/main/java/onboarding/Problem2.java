package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = toString(decrypt(cryptogram));
        return answer;
    }

    public static StringBuilder toStringBuilder(String crpytogram) {
        StringBuilder stringBuilder = new StringBuilder(crpytogram);
        return stringBuilder;
    }

    public static boolean isDuplicate(StringBuilder cryptogram, int index) {
        if (cryptogram.charAt(index) == cryptogram.charAt(index + 1)) {
            return true;
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

    public static StringBuilder removeDuplicate(StringBuilder crpytogram, int start, int range) {
        return crpytogram.delete(start, start + range);
    }

    public static StringBuilder decrypt(String cryptogram) {
        StringBuilder stringBuilderCryptogram = toStringBuilder(cryptogram);
        for (int i = 0; i < stringBuilderCryptogram.length() - 1; i++) {
            if (isDuplicate(stringBuilderCryptogram, i)) {
                int range = getDuplicateRange(stringBuilderCryptogram, i);
                removeDuplicate(stringBuilderCryptogram, i, range);
                i = -1;
            }
        }
        return stringBuilderCryptogram;
    }

    private static String toString(StringBuilder stringBuilderCryptogram) {
        return stringBuilderCryptogram.toString();
    }
}
