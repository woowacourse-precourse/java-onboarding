package onboarding;

public class Problem4 {
    private static final char LOWER_SUM = 'a' + 'z';
    private static final char UPPER_SUM = 'A' + 'Z';


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
        return alphabet >= 'a' && alphabet <= 'z';
    }

    private static boolean isUpper(char alphabet) {
        return alphabet >= 'A' && alphabet <= 'Z';
    }
}