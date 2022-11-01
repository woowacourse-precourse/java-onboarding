package onboarding;

/**
 * Problem 4
 * @author Davin An
 * @version 1.0
 */
public class Problem4 {

    /**
     * Replaces letters in a String according to dictionary.
     * Method performs all replacements within one traversal by manipulating the UNICODE values of each character.
     * @param word String to perform replacement on
     * @return String after replacement
     */
    public static String solution(String word) {
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < wordArray.length; i++) {
            if (Character.isLetter(wordArray[i])) {
                if (Character.isUpperCase(wordArray[i])) {
                    wordArray[i] = (char)(155 - (int)wordArray[i]);
                } else {
                    wordArray[i] = (char)(219 - (int)wordArray[i]);
                }
            }
        }
        return String.valueOf(wordArray);
    }

    public static void main(String[] args) {}
}
