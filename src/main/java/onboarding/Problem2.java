package onboarding;

public class Problem2 {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 1000;

    public static String solution(String cryptogram) {
        validateCryptogram(cryptogram);

        while (hasDuplicateWord(cryptogram)) {
            cryptogram = removeDuplicateWord(cryptogram);
        }
        return cryptogram;
    }

    private static void validateCryptogram(String cryptogram) throws IllegalArgumentException {
        if (!isValidRange(cryptogram.length())) {
            throw new IllegalArgumentException(String.format("올바른 문자열의 길이는 %d 이상 %d 이하입니다.", MIN_LENGTH, MAX_LENGTH));
        }

        if (!isOnlySmallLetters(cryptogram)) {
            throw new IllegalArgumentException("문자열은 소문자로만 구성되어 있어야 합니다.");
        }
    }

    private static boolean hasDuplicateWord(String cryptogram) {
        byte prevLetter = -1;

        for (byte letter : cryptogram.getBytes()) {
            if (prevLetter == letter) {
                return true;
            }
            prevLetter = letter;
        }
        return false;
    }

    private static String removeDuplicateWord(String cryptogram) {
        StringBuilder result = new StringBuilder();
        char prevLetter = 0;

        for (int i = 0; i < cryptogram.length(); i++) {
            char currentLetter = cryptogram.charAt(i);
            if (prevLetter != currentLetter) {
                result.append(currentLetter);
            } else {
                result.deleteCharAt(result.length() - 1);
            }
            prevLetter = cryptogram.charAt(i);
        }
        return result.toString();
    }

    private static boolean isValidRange(int length) {
        return length >= MIN_LENGTH && length <= MAX_LENGTH;
    }

    private static boolean isOnlySmallLetters(String cryptogram) {
        return cryptogram.matches("[a-z]+");
    }
}
