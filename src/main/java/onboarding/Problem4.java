package onboarding;

public class Problem4 {
    private static final int UPPER_CASE = 155;
    private static final int LOWER_CASE = 219;

    public static String solution(String word) {
        return reverseString(word);
    }

    public static String reverseString(String word) {
        String reversedWord = "";
        for (char character : word.toCharArray()) {

            if ('A' <= character && character <= 'Z') {
                reversedWord += reverseUpperCase(character);
                continue;
            }
            if ('a' <= character && character <= 'z') {
                reversedWord += reverseLowerCase(character);
                continue;
            }
            reversedWord += character;
        }

        return reversedWord;
    }

    public static String reverseUpperCase(char character) {
        int asciiVal = UPPER_CASE - (int) character;
        return Character.toString((char) asciiVal);
    }

    public static String reverseLowerCase(char character) {
        int asciiVal = LOWER_CASE - (int) character;
        return Character.toString((char) asciiVal);
    }
}
