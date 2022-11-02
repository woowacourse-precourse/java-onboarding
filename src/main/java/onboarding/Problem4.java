package onboarding;

public class Problem4 {
    private static final int DIFFERENCE_OF_UPPER_LOWER = 32;
    private static final int CHANGE_REFERENCE_VALUE = 155;

    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < word.length(); index++) {
            sb.append(getFinalChangeCharacter(word.charAt(index)));
        }
        return sb.toString();
    }

    public static char getFinalChangeCharacter(char c) {
        if (Character.isUpperCase(c)) {
            return getChangeCharacter(c);
        } else if (Character.isLowerCase(c)) {
            c = toUpperCase(c);
            char changeChar = getChangeCharacter(c);
            return toLowerCase(changeChar);
        }
        return c;
    }

    public static char getChangeCharacter(char c) {
        return (char) (CHANGE_REFERENCE_VALUE - c);
    }

    public static char toUpperCase(char c) {
        return (char) (c - DIFFERENCE_OF_UPPER_LOWER);
    }

    public static char toLowerCase(char c) {
        return (char) (c + DIFFERENCE_OF_UPPER_LOWER);
    }
}
