package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return decodeCryptogram(cryptogram);
    }

    private static boolean[] checkDuplicated(String cryptogram) {
        boolean[] isDuplicate = new boolean[cryptogram.length()];
        for (int i = 1; i < cryptogram.length(); i++) {
            if (cryptogram.charAt(i - 1) == cryptogram.charAt(i)) {
                isDuplicate[i - 1] = true;
                isDuplicate[i] = true;
            }
        }
        return isDuplicate;
    }

    private static String removeDupChars(String cryptogram, boolean[] isDuplicate) {
        String result = "";
        for (int i = 0; i < cryptogram.length(); i++) {
            if (!isDuplicate[i]) {
                result += cryptogram.charAt(i);
            }
        }
        return result;
    }

    private static String decodeCryptogram(String cryptogram) {
        String result = removeDupChars(cryptogram, checkDuplicated(cryptogram));
        if (result.equals(cryptogram)) {
            return result;
        }
        return decodeCryptogram(result);
    }
}
