package onboarding;

public class Problem4 {

    public static final int UPPERCASE_START_ALPHABET = 'A';
    public static final int UPPERCASE_END_ALPHABET = 'Z';
    public static final int LOWERCASE_START_ALPHABET = 'a';
    public static final int LOWERCASE_END_ALPHABET = 'z';

    public static String solution(String word) {
        char[] splitWord = word.toCharArray();

        for (int i = 0; i < splitWord.length; i++) {
            int checkAlphabet = checkUpperOrLower(splitWord[i]);

            if (checkAlphabet == 0) {
                splitWord[i] = (char) (UPPERCASE_END_ALPHABET - (splitWord[i] - UPPERCASE_START_ALPHABET));
            } else if (checkAlphabet == 1) {
                splitWord[i] = (char) (LOWERCASE_END_ALPHABET - (splitWord[i] - LOWERCASE_START_ALPHABET));
            }
        }

        return String.valueOf(splitWord);
    }

    public static int checkUpperOrLower(char alphabet) {
        if (alphabet >= LOWERCASE_START_ALPHABET && alphabet <= LOWERCASE_END_ALPHABET) {
            return 1;
        } else if (alphabet >= UPPERCASE_START_ALPHABET && alphabet <= UPPERCASE_END_ALPHABET) {
            return 0;
        }
        return -1;
    }

}
