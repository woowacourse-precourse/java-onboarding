package onboarding;

import java.util.stream.Collectors;

public class Problem4 {
    public static String solution(String word) {
        return word.chars()
                .mapToObj(e -> (char) e)
                .map(Problem4::contraryAlphabet)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private static char contraryAlphabet(char c) {
        if (!Character.isAlphabetic(c))
            return c;
        if (Character.isUpperCase(c))
            return (char) ('A' + ('Z' - c));
        else
            return (char) ('a' + ('z' - c));
    }
}
