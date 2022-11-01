package onboarding;

public class Problem4 {
    static final int MIN_LENGTH = 1;
    static final int MAX_LENGTH = 1000;
    static final String ERROR = "Error";
    public static String solution(String word) {
        String answer = "";
        if (!isValidInput(word)) {
            answer = ERROR;
            return answer;
        }
        answer = convertReverse(word);
        return answer;
    }

    private static String convertReverse(String word) {
        char currentChar;
        String convertedWord = "";

        for (int i = 0; i < word.length(); i++) {
            currentChar = word.charAt(i);
            convertedWord += convertChar(currentChar);
        }
        return convertedWord;
    }

    private static char convertChar(char currentChar) {
        if (Character.isAlphabetic(currentChar)) {
            if (Character.isUpperCase(currentChar)) {
                currentChar = (char)('A' + 'Z' - currentChar);
            }
            if (Character.isLowerCase(currentChar)) {
                currentChar = (char)('a' + 'z' - currentChar);
            }
        }
        return currentChar;
    }

    private static boolean isValidInput(String word) {
        return (isNotNull(word) && isValidRange(word));
    }

    private static boolean isValidRange(String word) {
        return word.length() >= MIN_LENGTH && word.length() <= MAX_LENGTH;
    }

    private static boolean isNotNull(String word) {
        return word != null;
    }
}
