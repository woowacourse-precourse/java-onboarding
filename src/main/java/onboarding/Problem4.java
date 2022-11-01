package onboarding;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        List<String> arr = Stream.of(word.split("")).collect(Collectors.toList());

        for (String a : arr) {
            if (a.equals(" ")) {
                answer.append(a);
                continue;
            }
            char c = a.charAt(0);
            answer.append(getOpposite(c));
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
