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
        char wordChar = word.charAt(0);
        int wordAscii = wordChar;

        if (Character.isUpperCase(wordChar)) {
            return asciiToString(UPPER_A_ASCII + UPPER_Z_ASCII - wordAscii);
        }
        if (Character.isLowerCase(wordChar)) {
            return asciiToString(LOWER_A_ASCII + LOWER_Z_ASCII - wordAscii);
        }
        return word;
    }

    private static String asciiToString(int ascii) {
        return String.valueOf((char) ascii);
    }

}
