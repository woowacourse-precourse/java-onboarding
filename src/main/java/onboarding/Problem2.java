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
        if (isLastTwoLettersDifferent(cryptogram, cryptogramChars)) {
            return Character.toString(cryptogramChars[cryptogram.length() - 1]);
        }
        return EMPTY_STRING;
    }

    private static boolean isLastTwoLettersDifferent(String cryptogram, char[] cryptogramChars) {
        return cryptogramChars[cryptogram.length() - 1] != cryptogramChars[cryptogram.length() - 2];
    }

    private static String removeDuplicatesOfMiddleLetters(String cryptogram, String refinedCryptogram, char[] cryptogramChars) {
        for (int i = 1; i < cryptogram.length() - 1; i++) {
            refinedCryptogram += checkDuplicatesOfMiddleLetters(cryptogramChars, i);
        }
        return refinedCryptogram;
    }

    private static String checkDuplicatesOfMiddleLetters(char[] cryptogramChars, int i) {
        if (isDifferentFromFollowingLetter(cryptogramChars, i) && isDifferentFromPreviousLetter(cryptogramChars, i)) {
            return Character.toString(cryptogramChars[i]);
        }
        return EMPTY_STRING;
    }

    private static boolean isDifferentFromPreviousLetter(char[] cryptogramChars, int i) {
        return cryptogramChars[i] != cryptogramChars[i - 1];
    }

    private static boolean isDifferentFromFollowingLetter(char[] cryptogramChars, int i) {
        return cryptogramChars[i] != cryptogramChars[i + 1];
    }

    private static String checkDuplicatesOfFirstLetter(char[] cryptogramChars) {
        if (isFirstTwoLettersDifferent(cryptogramChars)) {
            return Character.toString(cryptogramChars[0]);
        }
        return EMPTY_STRING;
    }

    private static boolean isFirstTwoLettersDifferent(char[] cryptogramChars) {
        return cryptogramChars[0] != cryptogramChars[1];
    }

    private static boolean isMoreThanTwoLetter(String cryptogram) {
        return cryptogram.length() > ONE_LETTER;
    }

    private static boolean isOneLetter(String cryptogram) {
        return cryptogram.length() == ONE_LETTER;
    }
}