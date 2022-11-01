package onboarding;

public class Problem4 {
    private static final String MESSAGE = "잘못된 입력입니다.";

    public static String solution(String word) {
        if (!isInputValid(word)) {
            throw new IllegalArgumentException(MESSAGE);
        }

        return convertWord(word);
    }

    private static String convertWord(String word) {
        char[] charArray = word.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        for (char c : charArray) {
            c = convertCharacter(c);
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    private static char convertCharacter(char c) {
        int valueDifference;

        if (isAlphabet(c)) {
            if (Character.isUpperCase(c)) {
                valueDifference = 'Z' - c + 'A';
            } else {
                valueDifference = 'z' - c + 'a';
            }
            c = (char) valueDifference;
        }

        return c;
    }

    private static boolean isInputValid(String word) {
        return word.length() > 1 && word.length() < 1000;
    }

    private static boolean isAlphabet(char c) {
        return (int) c >= 65 && (int) c <= 122;
    }
}
