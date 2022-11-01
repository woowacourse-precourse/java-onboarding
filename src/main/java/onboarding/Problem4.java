package onboarding;

public class Problem4 {

    public static String solution(String word) {
        StringBuilder reverseWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (validateAlphabet(word.charAt(i))) {
                reverseWord.append(replaceCharacter(word.charAt(i)));
                continue;
            }
            reverseWord.append(word.charAt(i));
        }

        return reverseWord.toString();
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

    private static char replaceCharacter(char character) {
        if (validateUpperCase(character)) {
            return (char) ('Z' - (character - 'A'));
        }
        return (char) ('z' - (character - 'a'));
    }
}
