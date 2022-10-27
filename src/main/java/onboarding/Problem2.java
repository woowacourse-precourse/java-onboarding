package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return decodedCrypto(cryptogram);
    }


    private static String decodedCrypto(String cryptogram) {
        while (true) {
            int duplicateLetterIndex = findDuplicateLetterIndex(cryptogram);
            if (duplicateLetterIndex == -1) {
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
        return -1;
    }

    private static String removeContinuousLetter(String word, int index) {
        StringBuilder sb = new StringBuilder(word);
        sb.delete(index, index + 2);
        return sb.toString();
    }
}
