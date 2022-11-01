package onboarding.problem2;

public class Decryptor {

    public String decodedCrypto(String cryptogram) {
        String decodedWord = cryptogram;

        while (true) {
            String deletedWord = removeDuplicateLetter(decodedWord);
            if (isNotInDuplicateLetter(decodedWord, deletedWord))
                break;
            decodedWord = deletedWord;
        }

        return decodedWord;
    }

    private boolean isNotInDuplicateLetter(String answer, String deletedWord) {
        return deletedWord.equals(answer);
    }

    public String removeDuplicateLetter(String word) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            if (isNotDuplicateBeforeAndAfterLetter(word, i)) {
                result.append(word.charAt(i));
            }
        }
        return result.toString();
    }

    private boolean isNotDuplicateBeforeAndAfterLetter(String word, int index) {
        return isNotEqualAfterLetter(word, index) && isNotEqualBeforeLetter(word, index);
    }

    private boolean isNotEqualBeforeLetter(String word, int index) {
        if (isFirstLetter(index)) {
            return true;
        }
        return word.charAt(index - 1) != word.charAt(index);
    }

    private boolean isFirstLetter(int index) {
        return index == 0;
    }

    private boolean isNotEqualAfterLetter(String word, int index) {
        if (isLastLetter(word, index)) {
            return true;
        }
        return word.charAt(index) != word.charAt(index + 1);
    }

    private boolean isLastLetter(String word, int index) {
        return index == word.length() - 1;
    }

}
