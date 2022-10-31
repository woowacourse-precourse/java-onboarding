package onboarding;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Problem4 {

    private static final int UPPER_A_ASCII = 'A';
    private static final int UPPER_Z_ASCII = 'Z';
    private static final int LOWER_A_ASCII = 'a';
    private static final int LOWER_Z_ASCII = 'z';
    private static final int WORD_SIZE_MIN = 1;
    private static final int WORD_SIZE_MAX = 1000;

    public static String solution(String word) {
        validateWord(word);
        return convertWord(word);
    }

    private static String convertWord(String word) {
        return Arrays.stream(word.split(""))
            .map(Problem4::treeFrogDictionary)
            .collect(Collectors.joining());
    }

    private static void validateWord(String word) {
        if (word.length() < WORD_SIZE_MIN || word.length() > WORD_SIZE_MAX) {
            throw new IllegalArgumentException();
        }
    }

    private static String treeFrogDictionary(String word) {
        char wordChar = word.charAt(0);

        if (Character.isUpperCase(wordChar)) {
            return asciiToString(UPPER_A_ASCII + UPPER_Z_ASCII - (int) wordChar);
        }
        if (Character.isLowerCase(wordChar)) {
            return asciiToString(LOWER_A_ASCII + LOWER_Z_ASCII - (int) wordChar);
        }
        return word;
    }

    private static String asciiToString(int ascii) {
        return String.valueOf((char) ascii);
    }

}
