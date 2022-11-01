package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return reverseString(word);
    }

    public static String reverseString(String word) {
        String result = "";
        for (char character : word.toCharArray()) {
            result += reverseChar(character);
        }
        return result;
    }

    public static char reverseChar(char character) {
        if (!isAlphabet(character)) {
            return character;
        }

        if (Character.isUpperCase(character)) {
            return reverseUpperCase(character);
        }
        return reverseLowerCase(character);
    }

    private static char reverseLowerCase(char character) {
        return (char) ('z' + 'a' - character);
    }

    private static char reverseUpperCase(char character) {
        return (char) ('Z' + 'A' - character);
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
}
