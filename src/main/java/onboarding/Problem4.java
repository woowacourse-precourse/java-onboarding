package onboarding;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        List<String> stringBySplit = Stream.of(word.split("")).collect(Collectors.toList());

        for (String s : stringBySplit) {
            if (" ".equals(s)) {
                answer.append(s);
                continue;
            }
            answer.append(getOpposite(s.charAt(0)));
        }

        return answer.toString();
    }

    private static char getOpposite(char c) {
        if (isUpper(c)) {
            return (char)(155 - c);
        }

        return (char)(219 - c);
    }

    private static boolean isUpper(char c) {
        return Character.isUpperCase(c);
    }
}
