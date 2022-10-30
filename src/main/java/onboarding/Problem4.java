package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem4 {

    private static final int Z_UPPER_CASE = 90;
    private static final int Z_LOWER_CASE = 122;


    public static String solution(String word) {
        List<Character> result = new ArrayList<>();


        for (int i = 0; i < word.length(); i++) {
            int ascii = word.toCharArray()[i];

            if (Character.isAlphabetic(ascii)) {
                ascii = changeAsciiValue(ascii);
            }
            result.add((char) ascii);
        }

        return result.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private static int changeAsciiValue(int ascii) {
        int val = ascii + 25;

        if (val > Z_LOWER_CASE) {
            return Z_LOWER_CASE - ((val) % Z_LOWER_CASE);
        }

        if (val > Z_UPPER_CASE && val != Z_LOWER_CASE) {
            return Z_UPPER_CASE - ((val) % Z_UPPER_CASE);
        }

        return val;

    }
}
