package onboarding;

public class Problem4 {

    private enum CharValue {
        VALUE_UPPER_A('A'),
        VALUE_UPPER_Z('Z'),
        VALUE_LOWER_A('a'),
        VALUE_LOWER_Z('z');

        private final int value;

        CharValue(int value) {
            this.value = value;
        }
    }

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for (char value : word.toCharArray()) {
            answer.append(getNewValue(value));
        }
        return answer.toString();
    }

    private static char getNewValue(char value) {
        if (Character.isUpperCase(value)) {
            return getNewUpperCaseValue(value);
        }
        if (Character.isLowerCase(value)) {
            return getNewLowerCaseValue(value);
        }
        return value;
    }

    private static char getNewLowerCaseValue(char value) {
        return (char) (CharValue.VALUE_LOWER_A.value + CharValue.VALUE_LOWER_Z.value - value);
    }

    private static char getNewUpperCaseValue(char value) {
        return (char) (CharValue.VALUE_UPPER_A.value + CharValue.VALUE_UPPER_Z.value - value);
    }
}