package onboarding;

public class Problem4 {
    public static final char A_LOWER_CASE = 'a';
    public static final char Z_LOWER_CASE = 'z';
    public static final char A_UPPER_CASE = 'A';
    public static final char Z_UPPER_CASE = 'Z';

    public static String solution(String word) {
        return convertIntoBlueFrogWord(word);
    }

    private static String convertIntoBlueFrogWord(String word) {
        char[] letters = word.toCharArray();
        for (char letter : letters) {
            if (isLowerCase(letter)) {
            }
            if (isUpperCase(letter)) {
            }
        }
        return null;
    }

    private static boolean isUpperCase(char letter) {
        return letter >= A_UPPER_CASE && letter <= Z_UPPER_CASE;
    }

    private static boolean isLowerCase(char letter) {
        return letter >= A_LOWER_CASE && letter <= Z_LOWER_CASE;
    }
}
