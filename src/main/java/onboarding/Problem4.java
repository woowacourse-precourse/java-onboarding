package onboarding;

/**
 *  reverseAlphabet 메서드 각 char문자를 a-z 반대로 반환해준다.
 */

public class Problem4 {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 1000;

    public static String solution(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            sb.append(reverseAlphabet(word.charAt(i)));
        }

        return sb.toString();
    }
    private static char reverseAlphabet(char letter) {
        if (!Character.isAlphabetic(letter)) return letter;

        if (Character.isUpperCase(letter)) return (char) ('Z' - letter + 'A');

        if (Character.isLowerCase(letter)) return (char) ('z' - letter + 'a');

        return letter;
    }

}