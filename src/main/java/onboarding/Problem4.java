package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static boolean isAlphabet(char character) {
        if (character >= 'A' && character <= 'Z') {
            return true;
        }

        if (character >= 'a' && character <= 'z') {
            return true;
        }

        return false;
    }

    public static char reverseChar(char character) {
        if (!isAlphabet(character)) {
            return character;
        }

        if (Character.isUpperCase(character)) {
            return (char) ('Z' + 'A' - character);
        }
        return (char) ('z' + 'a' - character);
    }
}
