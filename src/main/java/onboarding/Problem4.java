package onboarding;

public class Problem4 {
    public static final char A_LOWER_CASE = 'a';
    public static final char Z_LOWER_CASE = 'z';
    public static final char A_UPPER_CASE = 'A';
    public static final char Z_UPPER_CASE = 'Z';
    public static final String EMPTY_STRING = "";
    public static final int LOWER_CASE_CONVERTER = 155;

    public static String solution(String word) {
        return convertIntoBlueFrogWord(word);
    }

    private static String convertIntoBlueFrogWord(String word) {
        char[] letters = word.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            char letter = letters[i];
            if (isLowerCase(letter)) {
                letters[i] = convertLowerCaseIntoFrogLetter(letter);
            }
            if (isUpperCase(letter)) {
            }
        }
        return null;
    }

    private static char convertLowerCaseIntoFrogLetter(char letter) {
        return (char)(LOWER_CASE_CONVERTER - letter);
    }

    private static boolean isUpperCase(char letter) {
        return letter >= A_UPPER_CASE && letter <= Z_UPPER_CASE;
    }

    private static boolean isLowerCase(char letter) {
        return letter >= A_LOWER_CASE && letter <= Z_LOWER_CASE;
    }
}
