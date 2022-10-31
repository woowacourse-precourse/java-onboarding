package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char originalChar = word.charAt(i);
            answer.append(getGreenFrogChar(originalChar));
        }

        return answer.toString();
    }

    private static char getGreenFrogChar(char originalChar) {
        if (Character.isAlphabetic(originalChar)) {
            return encryptGreenFrogChar(originalChar);
        }

        return originalChar;
    }

    private static char encryptGreenFrogChar(char originalChar) {
        if (isCapitalLetter(originalChar)) {
            return getUpperCharConvert(originalChar);
        }

        return getLowerCharConvert(originalChar);
    }

    private static boolean isCapitalLetter(char checkChar) {
        return Character.isUpperCase(checkChar);
    }

    private static char getUpperCharConvert(char originalChar) {
        return (char) ('A' + ('Z' - originalChar));
    }

    private static char getLowerCharConvert(char originalChar) {
        return (char) ('a' + ('z' - originalChar));
    }
}
