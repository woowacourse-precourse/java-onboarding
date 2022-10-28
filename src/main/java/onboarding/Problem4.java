package onboarding;

import static java.lang.Character.*;

public class Problem4 {
    public static final String INVALID_STRING_LENGTH_MASSAGE_FORMAT = "문자열은 %d 이상 %d 이하의 길이로 주어져야 합니다.";

    public static final int MIN_LENGTH = 1;
    public static final int MAX_LENGTH = 1000;

    public static String solution(String word) {
        isWordLengthBetween(word, MIN_LENGTH, MAX_LENGTH);

        StringBuilder stringBuilder = new StringBuilder();
        word.chars().forEach(ascii -> stringBuilder.append(reverse(ascii)));

        return stringBuilder.toString();
    }

    private static void isWordLengthBetween(String target, int min, int max) {
        if (target.length() < min || max < target.length()) {
            throw new IllegalArgumentException(String.format(INVALID_STRING_LENGTH_MASSAGE_FORMAT, min, max));
        }
    }

    private static char reverse(int ascii) {
        if (isLowerCase(ascii)) {
            return reverseLowerCase(ascii);
        } else if (isUpperCase(ascii)) {
            return reverseUpperCase(ascii);
        }
        return (char)ascii;
    }

    private static char reverseUpperCase(int ascii) {
        return (char)(90 - (ascii - 65));
    }

    private static char reverseLowerCase(int ascii) {
        return (char)(122 - (ascii - 97));
    }
}
