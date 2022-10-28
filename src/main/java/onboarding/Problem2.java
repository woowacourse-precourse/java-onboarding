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
        String refinedCryptogram = removeDuplicateCharacters(cryptogram);
        if (cryptogram.equals(refinedCryptogram)) {
            return cryptogram;
        }
        return decrypt(refinedCryptogram);
    }

    private static String removeDuplicateCharacters(String cryptogram) {
        char[] cryptogramChars = cryptogram.toCharArray();
        String refinedCryptogram = EMPTY_STRING;
        if (cryptogram.length() == ONE_LETTER) {
            refinedCryptogram = cryptogram;
        }
        if (cryptogram.length() > ONE_LETTER && cryptogramChars[0] != cryptogramChars[1]) {
            refinedCryptogram += cryptogramChars[0];
        }
        for (int i = 1; i < cryptogram.length() - 1; i++) {
            if (cryptogramChars[i] != cryptogramChars[i + 1] && cryptogramChars[i] != cryptogramChars[i - 1]) {
                refinedCryptogram += cryptogramChars[i];
            }
        }
        if (cryptogram.length() > ONE_LETTER && cryptogramChars[cryptogram.length() - 1] != cryptogramChars[cryptogram.length() - 2]) {
            refinedCryptogram += cryptogramChars[cryptogram.length() - 1];
        }
        return refinedCryptogram;
    }
}
