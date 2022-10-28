package onboarding;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Problem4 {

    private static final int UPPER_A_ASCII = 'A';
    private static final int UPPER_Z_ASCII = 'Z';
    private static final int LOWER_A_ASCII = 'a';
    private static final int LOWER_Z_ASCII = 'z';

    public static String solution(String word) {
        return Arrays.stream(word.split(""))
            .map(Problem4::treeFrogDictionary)
            .collect(Collectors.joining());
    }

    private static String treeFrogDictionary(String word) {
        if (Character.isUpperCase(word.charAt(0))) {
            return String.valueOf((char) (UPPER_A_ASCII + UPPER_Z_ASCII - (int) word.charAt(0)));
        }
        if (Character.isLowerCase(word.charAt(0))) {
            return String.valueOf((char) (LOWER_A_ASCII + LOWER_Z_ASCII - (int) word.charAt(0)));
        }
        return word;
    }
}
