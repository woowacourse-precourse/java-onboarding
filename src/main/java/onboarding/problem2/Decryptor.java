package onboarding.problem2;

public class Decryptor {
    private static int NO_DUPLICATE_LETTER = -1;

    public String decodedCrypto(String cryptogram) {
        String decodedWord = cryptogram;
        while (true) {
            int duplicateLetterIndex = findDuplicateLetterIndex(decodedWord);
            if (duplicateLetterIndex == NO_DUPLICATE_LETTER) {
                break;
            }
            decodedWord = removeContinuousLetter(decodedWord, duplicateLetterIndex);
        }
        return decodedWord;
    }

    private int findDuplicateLetterIndex(String word) {
        for (int index = 0; index < word.length() - 1; index++) {
            char leftLetter = word.charAt(index);
            char rightLetter = word.charAt(index + 1);
            if (leftLetter == rightLetter) {
                return index;
            }
        }
        return NO_DUPLICATE_LETTER;
    }

    private String removeContinuousLetter(String word, int index) {
        StringBuilder builder = new StringBuilder(word);
        builder.delete(index, index + 2);
        return builder.toString();
    }
}
