package onboarding;

public class Problem4 {

    public static final int UPPERCASE_START_ALPHABET = 'A';
    public static final int UPPERCASE_END_ALPHABET = 'Z';
    public static final int LOWERCASE_START_ALPHABET = 'a';
    public static final int LOWERCASE_END_ALPHABET = 'z';

    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static int checkUpperOrLower(char alphabet) {
        if (alphabet >= LOWERCASE_START_ALPHABET && alphabet <= LOWERCASE_END_ALPHABET) {
            return 1;
        }
        else if (alphabet >= UPPERCASE_START_ALPHABET && alphabet <= UPPERCASE_END_ALPHABET) {
            return 0;
        }
        return -1;
    }

}
