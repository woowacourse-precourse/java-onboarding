package onboarding;

/**
 * reverseAlphabet 메서드 각 char문자를 a-z 반대로 반환해준다.
 * isProperLength 메서드 문자의 길이가 올바른지 확인
 */

public class Problem4 {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 1000;

    public static String solution(String word) {
        isProperLength(word);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            sb.append(reverseAlphabet(word.charAt(i)));
        }

        return sb.toString();
    }

    private static void isProperLength(String word) {
        if (word.length() < MIN_LENGTH || word.length() > MAX_LENGTH)
            throw new IllegalArgumentException("words는 길이가 1이상 1000이하인 문자열입니다.");
    }

    private static char reverseAlphabet(char letter) {
        if (!Character.isAlphabetic(letter)) return letter;

        if (Character.isUpperCase(letter)) return (char) ('Z' - letter + 'A');

        if (Character.isLowerCase(letter)) return (char) ('z' - letter + 'a');

        return letter;
    }

}