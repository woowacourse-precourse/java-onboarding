package onboarding;

public class Problem2 {
    private static int NO_DUPLICATE_LETTER = -1;
    public static String solution(String cryptogram) {
        return decodedCrypto(cryptogram);
    }


    private static String decodedCrypto(String cryptogram) {
        while (true) {
            int duplicateLetterIndex = findDuplicateLetterIndex(cryptogram);
            if (duplicateLetterIndex == NO_DUPLICATE_LETTER) {
                break;
            }
            cryptogram = removeContinuousLetter(cryptogram, duplicateLetterIndex);
        }
        return cryptogram;
    }

    private static int findDuplicateLetterIndex(String word) {
        for (int index = 0; index < word.length() - 1; index++) {
            char leftLetter = word.charAt(index);
            char rightLetter = word.charAt(index + 1);
            if (leftLetter == rightLetter) {
                return index;
            }
        }
        return NO_DUPLICATE_LETTER;
    }

    private static String removeContinuousLetter(String word, int index) {
        StringBuilder builder = new StringBuilder(word);
        builder.delete(index, index + 2);
        return builder.toString();
    }
}
