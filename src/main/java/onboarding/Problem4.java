package onboarding;


public class Problem4 {
    static final String EXCEPTION = "[ERROR]";
    static final int LENGTH_UPPERBOUND = 1000;
    static final int LENGTH_LOWERBOUND = 1;
    static final char A_LOWERCASE = 'a';
    static final char A_UPPERCASE = 'A';
    static final char Z_LOWERCASE = 'z';
    static final char Z_UPPERCASE = 'Z';

    public static String solution(String word) {
        String solution = getSolution(word);
        return solution;
    }
    public static String getSolution(String word) {
        if (checkValidation(word)) {
            String result = changeWord(word);
            return result;
        }
        return EXCEPTION;
    }
    public static boolean checkValidation(String word) {
        if (word.length() > LENGTH_UPPERBOUND || word.length() < LENGTH_LOWERBOUND) {
            return false;
        }
        return true;
    }
    public static char changeAlphabet(char character) {
        if ((character < A_LOWERCASE || character > Z_LOWERCASE) &&
                (character < A_UPPERCASE || character > Z_UPPERCASE)) {
            return character;
        }
        if (character < Z_UPPERCASE) {
            return (char)(Z_UPPERCASE - character + A_UPPERCASE);
        }
        return (char)(Z_LOWERCASE - character + A_LOWERCASE);
    }
    public static String changeWord(String word) {
        String newWord = "";
        for (int i = 0; i < word.length(); i++) {
            char reverseChar = changeAlphabet(word.charAt(i));
            newWord += reverseChar;
        }
        return newWord;
    }
}

