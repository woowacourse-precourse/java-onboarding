package onboarding;

/**
 *  reverseAlphabet 메서드 각 char문자를 a-z 반대로 반환해준다.
 */

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
    private static char reverseAlphabet(char letter) {
        if (!Character.isAlphabetic(letter)) return letter;

        if (Character.isUpperCase(letter)) return (char) ('Z' - letter + 'A');

        if (Character.isLowerCase(letter)) return (char) ('z' - letter + 'a');

        return letter;
    }

}