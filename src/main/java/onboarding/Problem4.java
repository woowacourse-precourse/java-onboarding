package onboarding;

public class Problem4 {

    public static String solution(String word) {
        StringBuilder reverseWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (validateAlphabet(word.charAt(i))) {

            }

        }

        return null;
    }

    private static boolean validateAlphabet(char character) {
        if (character >= 'A' && character <= 'Z' || character >= 'a' && character <= 'z') {
            return true;
        }
        return false;
    }
    private static boolean validateUpperCase(char character) {
        if (character >= 'A' && character <= 'Z') {
            return true;
        }
        return false;
    }
}
