package onboarding;

import java.util.stream.Collectors;

public class Problem4 {
    public static String solution(String word) {

        return word.chars().map(Problem4::contraryTo).mapToObj(Character::toString).collect(Collectors.joining());
    }
    private static int contraryTo(int s) {
        if (Character.isUpperCase(s)) {
            return 155 - s;
        }
        if (Character.isLowerCase(s)) {
            return 219 - s;
        }
        return s;
    }

}