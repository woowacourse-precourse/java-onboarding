package onboarding;

public class Problem4 {

    public static final char FIRST_LOWER = 'a';
    public static final char LAST_LOWER = 'z';
    public static final char FIRST_UPPER = 'A';
    public static final char LAST_UPPER = 'Z';
    public static final char LOWER_SUM = 'a' + 'z';
    public static final char UPPER_SUM = 'A' + 'Z';


    public static String solution(String word) {
        return conversionString(word);
    }

    public static String conversionString(String word) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char character : word.toCharArray()) {
            stringBuilder.append(conversionChar(character));
        }

        return stringBuilder.toString();
    }


    private static char conversionChar(char character) {
        if (isLower(character)) {
            return (char) (LOWER_SUM - character);
        }

        if (isUpper(character)) {
            return (char) (UPPER_SUM - character);
        }

        return character;
    }

    private static boolean isLower(char alphabet) {
        return alphabet >= FIRST_LOWER && alphabet <= LAST_LOWER;
    }

    private static boolean isUpper(char alphabet) {
        return alphabet >= FIRST_UPPER && alphabet <= LAST_UPPER;
    }
}