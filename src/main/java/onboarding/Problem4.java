package onboarding;

import static java.lang.Character.*;

public class Problem4 {
    public static String solution(String word) {
        return stringConverter(word);
    }

    private static String stringConverter(String target) {
        char[] targetArray = getCharArray(target);

        StringBuilder builder = new StringBuilder();
        for (char ch : targetArray) {
            builder.append(charConverter(ch));
        }
        return String.valueOf(builder);
    }

    private static char[] getCharArray(String target) {
        return target.toCharArray();
    }

    private static char charConverter(char target) {
        if (isUpperCase(target)) {
            return (char) ('Z' - (target - 'A'));
        } else if (isLowerCase(target)) {
            return (char) ('z' - (target - 'a'));
        } else {
            return target;
        }
    }
}
