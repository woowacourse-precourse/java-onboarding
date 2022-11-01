package onboarding;

class FrogDictionary {
    private static final int LOWER_CASE_ASCII_OF_A = 97;
    private static final int LOWER_CASE_ASCII_OF_Z = 122;
    private static final int UPPER_CASE_ASCII_OF_A = 65;
    private static final int UPPER_CASE_ASCII_OF_Z = 90;

    public static char find(char targetChar) {
        return transformCharacter(targetChar);
    }

    private static char transformCharacter(char targetChar) {
        if (isLowerCase(targetChar)) {
            return reverseAlphabet(targetChar, LOWER_CASE_ASCII_OF_A + LOWER_CASE_ASCII_OF_Z);
        }
        if (isUpperCase(targetChar)) {
            return reverseAlphabet(targetChar, UPPER_CASE_ASCII_OF_A + UPPER_CASE_ASCII_OF_Z);
        }
        return targetChar;
    }

    private static char reverseAlphabet(char targetChar, int offset) {
        return (char) (offset - (int) targetChar);
    }

    private static boolean isUpperCase(char targetChar) {
        if (targetChar >= UPPER_CASE_ASCII_OF_A && targetChar <= UPPER_CASE_ASCII_OF_Z) {
            return true;
        }
        return false;
    }

    private static boolean isLowerCase(char targetChar) {
        if (targetChar >= LOWER_CASE_ASCII_OF_A && targetChar <= LOWER_CASE_ASCII_OF_Z) {
            return true;
        }
        return false;
    }
}

public class Problem4 {
    public static String solution(String word) {
        StringBuilder transformedWord = new StringBuilder();
        char[] wordCharacters = word.toCharArray();
        for (char targetChar : wordCharacters) {
            transformedWord.append(FrogDictionary.find(targetChar));
        }
        String answer = transformedWord.toString();
        return answer;
    }
}
