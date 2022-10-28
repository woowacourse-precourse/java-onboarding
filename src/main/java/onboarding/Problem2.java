package onboarding;

public class Problem2 {
    public static final String EMPTY_STRING = "";
    public static final int ONE_LETTER = 1;

    public static String solution(String cryptogram) {
        return decrypt(cryptogram);
    }

    private static String decrypt(String cryptogram) {
        if (cryptogram.equals(EMPTY_STRING)) {
            return cryptogram;
        }
        String refinedCryptogram = removeDuplicates(cryptogram);
        if (cryptogram.equals(refinedCryptogram)) {
            return cryptogram;
        }
        return decrypt(refinedCryptogram);
    }

    private static String removeDuplicates(String cryptogram) {
        String refinedCryptogram = EMPTY_STRING;
        if (isOneLetter(cryptogram)) {
            refinedCryptogram = cryptogram;
        }
        if (isMoreThanTwoLetter(cryptogram)) {
            refinedCryptogram = removeDuplicatesOfMoreThanTwoLetters(cryptogram, refinedCryptogram);
        }
        return refinedCryptogram;
    }

    private static String removeDuplicatesOfMoreThanTwoLetters(String cryptogram, String refinedCryptogram) {
        char[] cryptogramChars = cryptogram.toCharArray();
        refinedCryptogram += checkDuplicatesOfFirstLetter(cryptogramChars);
        refinedCryptogram = removeDuplicatesOfMiddleLetters(cryptogram, refinedCryptogram, cryptogramChars);
        refinedCryptogram += checkDuplicatesOfLastLetter(cryptogram, cryptogramChars);

        return refinedCryptogram;
    }

    private static String checkDuplicatesOfLastLetter(String cryptogram, char[] cryptogramChars) {
        if (cryptogramChars[cryptogram.length() - 1] != cryptogramChars[cryptogram.length() - 2]) {
            return Character.toString(cryptogramChars[cryptogram.length() - 1]);
        }
        return EMPTY_STRING;
    }

    private static String removeDuplicatesOfMiddleLetters(String cryptogram, String refinedCryptogram, char[] cryptogramChars) {
        for (int i = 1; i < cryptogram.length() - 1; i++) {
            refinedCryptogram += checkDuplicatesOfMiddleLetters(cryptogramChars, i);
        }
        return refinedCryptogram;
    }

    private static String checkDuplicatesOfMiddleLetters(char[] cryptogramChars, int i) {
        if (cryptogramChars[i] != cryptogramChars[i + 1] && cryptogramChars[i] != cryptogramChars[i - 1]) {
            return Character.toString(cryptogramChars[i]);
        }
        return EMPTY_STRING;
    }

    private static String checkDuplicatesOfFirstLetter(char[] cryptogramChars) {
        if (cryptogramChars[0] != cryptogramChars[1]) {
            return Character.toString(cryptogramChars[0]);
        }
        return EMPTY_STRING;
    }

    private static boolean isMoreThanTwoLetter(String cryptogram) {
        return cryptogram.length() > ONE_LETTER;
    }

    private static boolean isOneLetter(String cryptogram) {
        return cryptogram.length() == ONE_LETTER;
    }
}