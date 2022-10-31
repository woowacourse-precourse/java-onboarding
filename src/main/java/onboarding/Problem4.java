package onboarding;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for (char character : word.toCharArray()) {
            if (isAlphabet(character))
                answer.append(convertToTreeFrogWay(character));
            else
                answer.append(character);
        }
        return answer.toString();
    }

    private static char convertToTreeFrogWay(char alphabet) {
        if (isUpperCase(alphabet))
            return convertWhenUpper(alphabet);
        return convertWhenLower(alphabet);
    }

    private static char convertWhenUpper(char alphabet) {
        int diff = alphabet - 'A';
        return (char)('Z' - diff);
    }

    private static char convertWhenLower(char alphabet) {
        int diff = alphabet - 'a';
        return (char)('z' - diff);
    }

    private static boolean isAlphabet(char character) {
        return isUpperCase(character) || isLowerCase(character);
    }

    private static boolean isUpperCase(char alphabet) {
        if (65 <= alphabet && alphabet <= 90)
            return true;
        return false;
    }

    private static boolean isLowerCase(char alphabet) {
        if (97 <= alphabet && alphabet <= 122)
            return true;
        return false;
    }
}
