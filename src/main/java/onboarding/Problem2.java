package onboarding;

public class Problem2 {
    static boolean isDuplicateWord;

    public static String solution(String cryptogram) {

        String duplicateRemovedWord = cryptogram;
        isDuplicateWord = true;

        while(isDuplicateWord) {
            if("".equals(duplicateRemovedWord)) {
                break;
            }
            duplicateRemovedWord = getDuplicateRemovedWord(duplicateRemovedWord);
        }

        return duplicateRemovedWord;
    }

    private static String getDuplicateRemovedWord(String word) {
        int wordLength = word.length();
        int jumpIndexCount = 1;
        StringBuilder duplicateRemovedWord = new StringBuilder();

        int i = 0;
        while(i < wordLength - 1) {
            if(word.charAt(i) != word.charAt(i + 1)) {
                duplicateRemovedWord.append(word.charAt(i));
                i++;
                continue;
            }

            int j = i;
            while(j < wordLength - 1) {
                if(word.charAt(j) != word.charAt(j + 1)) {
                    break;
                }
                jumpIndexCount++;
                j++;
            }

            i += jumpIndexCount;
            jumpIndexCount = 1;
        }

        if(word.charAt(wordLength - 1) != word.charAt(wordLength - 2)) {
            duplicateRemovedWord.append(word.charAt(wordLength - 1));
        }

        isDuplicateWord = !duplicateRemovedWord.toString().equals(word);

        return duplicateRemovedWord.toString();
    }
}