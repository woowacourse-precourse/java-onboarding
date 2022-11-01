package onboarding;

import java.util.stream.Collectors;

public class Problem4 {
    public static String solution(String word) {
        return word.chars().mapToObj(ch -> (char) ch)
                .map(Problem4::convertCharacter)
                .map(Object::toString)
                .collect(Collectors.joining(""));
    }

    private static char convertCharacter(char ch) {
        if (!Character.isAlphabetic(ch)) {
            return ch;
        }
        int difference = 'm' - Character.toLowerCase(ch) + 1;
        return (char) (ch + difference * 2 - 1);
    }

}