package onboarding;

public class Problem4 {

    private static final int WORD_MIN_LENGTH = 1;
    private static final int WORD_MAX_LENGTH = 1000;
    private static final char LOWERCASE_A = 'a';
    private static final char LOWERCASE_Z = 'z';
    private static final char UPPERCASE_A = 'A';
    private static final char UPPERCASE_Z = 'Z';

    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static boolean checkWordLengthValid(String word) {
        return WORD_MIN_LENGTH <= word.length() && word.length() <= WORD_MAX_LENGTH;
    }

    public static boolean checkLowercaseAlphabet(char letter) {
        return LOWERCASE_A <= letter && letter <= LOWERCASE_Z;
    }

    public static boolean checkUppercaseAlphabet(char letter) {
        return UPPERCASE_A <= letter && letter <= UPPERCASE_Z;
    }
}
