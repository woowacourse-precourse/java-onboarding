package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem4 {
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

        if (ascii + 25 > 122) {
            return 122 - ((ascii + 25) % 122);
        }

        if (ascii + 25 > 90 && ascii != 97) {
            return 90 - ((ascii + 25) % 90);
        }

        return ascii + 25;

    }
}
