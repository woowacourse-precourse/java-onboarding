package onboarding;

import java.util.List;
import java.util.stream.Collectors;

public class Problem4 {

    private static final int Z_UPPER_CASE = 90;
    private static final int Z_LOWER_CASE = 122;

    public static String solution(String word) {
        return getWordByStrangeDictionaryLogic(word);
    }

    private static String getWordByStrangeDictionaryLogic(String word) {
        List<Character> chars = word.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        chars.replaceAll(c -> Character.isAlphabetic(c) ? (char) changeAsciiValue(c) : c);
        return joiningChars(chars);
    }

    private static int changeAsciiValue(char ascii) {
        int val = ascii + 25;

        if (val > Z_LOWER_CASE) {
            return Z_LOWER_CASE - ((val) % Z_LOWER_CASE);
        }

        if (val > Z_UPPER_CASE && val != Z_LOWER_CASE) {
            return Z_UPPER_CASE - ((val) % Z_UPPER_CASE);
        }
        return val;
    }

    private static String joiningChars(List<Character> result) {
        return result.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
