package onboarding;

import static java.lang.Character.*;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        word.chars().forEach(ascii -> stringBuilder.append(reverse(ascii)));

        return stringBuilder.toString();
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
