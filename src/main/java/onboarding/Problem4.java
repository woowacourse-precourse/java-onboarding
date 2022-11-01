package onboarding;

import java.util.stream.Collectors;

public class Problem4 {
    public static final int UPPER_SUM = 155;
    public static final int LOWER_SUM = 219;

    public static String solution(String word) {
        return toFrogWord(word);
    }

    public static char toFrogChar(char c) {
        if(Character.isUpperCase(c))
            return (char)(UPPER_SUM-c);
        if(Character.isLowerCase(c))
            return (char)(LOWER_SUM-c);
        return c;
    }

    public static String toFrogWord(String word) {
        return word.chars()
                .mapToObj(c -> (char)c)
                .map(Problem4::toFrogChar)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
