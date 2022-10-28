package onboarding;

import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problem4 {
    private static final int MINIMUM_INPUT = 1;
    private static final int MAXIMUM_INPUT = 1000;
    private static final String INPUT_ERROR = "INPUT_ERROR";
    private static final int AZ_TERM = 25;
    private static final String PATTERN = "^[a-zA-Z\\s]*$";
    private static HashMap<Character, String> frogMap = new HashMap<>();

    public static String solution(String word) {
        if (isExceptionInput(word)) return INPUT_ERROR;

        makeFrogMap();

        return Stream.of(word.split(""))
                .map(x -> frogMap.get(x.charAt(0)))
                .collect(Collectors.joining());
    }

    private static void makeFrogMap() {
        frogMap.put(' ', " ");
        makeFrogMapAtoZ('z');
        makeFrogMapAtoZ('Z');
    }

    private static void makeFrogMapAtoZ(char z) {
        char a = (char) (z - AZ_TERM);
        IntStream.rangeClosed(a, z)
                .forEach(x -> {
                    char changeTo = (char) (z - x + a);
                    frogMap.put((char) x, String.valueOf(changeTo));
                });
    }

    private static boolean isExceptionInput(String word) {
        return validOnlyAlphabet(word) || validLength(word);
    }

    private static boolean validOnlyAlphabet(String word) {
        return !Pattern.matches(PATTERN, word);
    }

    private static boolean validLength(String word) {
        return word.length() < MINIMUM_INPUT || word.length() > MAXIMUM_INPUT;
    }
}
