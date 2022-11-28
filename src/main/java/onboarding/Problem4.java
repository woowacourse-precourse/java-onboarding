package onboarding;

public class Problem4 {

    public static final int VALUE_UPPER_A = 65;
    public static final int VALUE_UPPER_Z = 90;
    public static final int VALUE_LOWER_A = 97;
    public static final int VALUE_LOWER_Z = 122;

    public static String solution(String word) {

        StringBuilder answer = new StringBuilder();

        for (char value : word.toCharArray()) {
            answer.append(getNewValue(value));
        }

        return answer.toString();
    }

    private static char getNewValue(char value) {
        if (Character.isAlphabetic(value)) {
            if (Character.isUpperCase(value)) {
                return getNewUpperCaseValue(value);
            }
            if (Character.isLowerCase(value)) {
                return getNewLowerCaseValue(value);
            }
        }
        return value;
    }

    private static char getNewLowerCaseValue(char value) {
        return (char) (VALUE_LOWER_A + VALUE_LOWER_Z - value);
    }

    private static char getNewUpperCaseValue(char value) {
        return (char) (VALUE_UPPER_A + VALUE_UPPER_Z - value);
    }
}