package onboarding;

public class Problem4 {
    private static int UPPER_CASE_A = 65;
    private static int UPPER_CASE_Z = 90;
    private static int LOWER_CASE_A = 97;
    private static int LOWER_CASE_Z = 122;
    private static int UPPER_CASE_TOTAL = 155;
    private static int LOWER_CASE_TOTAL = 219;

    public static String solution(String word) {
        String answer = "";
        answer = toString(makeFrogWord(word));
        return answer;
    }

    public static StringBuilder toStringBuilder(String word) {
        return new StringBuilder(word);
    }

    public static boolean isUpperCase(char character) {
        if (character >= UPPER_CASE_A && character <= UPPER_CASE_Z) {
            return true;
        }
        return false;
    }

    public static boolean isLowerCase(char character) {
        if (character >= LOWER_CASE_A && character <= LOWER_CASE_Z) {
            return true;
        }
        return false;
    }

    public static void reverseUpperCase(StringBuilder stringBuilder, char character, int index) {
        char reverse = (char) (UPPER_CASE_TOTAL - character);
        stringBuilder.setCharAt(index, reverse);
    }

    public static void reverseLowerCase(StringBuilder stringBuilder, char character, int index) {
        char reverse = (char) (LOWER_CASE_TOTAL - character);
        stringBuilder.setCharAt(index, reverse);
    }

    public static StringBuilder makeFrogWord(String word) {
        StringBuilder frogWord = toStringBuilder(word);
        for (int i = 0; i < frogWord.length(); i++) {
            char character = frogWord.charAt(i);
            if (isUpperCase(character)) {
                reverseUpperCase(frogWord, character, i);
            }
            if (isLowerCase(character)) {
                reverseLowerCase(frogWord, character, i);
            }
        }
        return frogWord;
    }

    public static String toString(StringBuilder stringBuilder) {
        return stringBuilder.toString();
    }
}
