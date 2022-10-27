package onboarding;

import java.util.stream.Collectors;

public class Problem4 {
    public static String solution(String word) {
        return word.chars().map(Problem4::swapAlphabet).mapToObj(Character::toString).collect(Collectors.joining());
    }

    private static int swapAlphabet(int i) {
        if (i > 96 && i < 123) {
            return 219 - i;
        }
        if (i > 64 && i < 91) {
            return 155 - i;
        }
        return i;
    }
}
