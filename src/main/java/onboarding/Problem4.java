package onboarding;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        List<String> arr = Stream.of(word.split("")).collect(Collectors.toList());

        for (String a : arr) {
            System.out.println(isUpper(a.charAt(0)));
        }

        return answer;
    }

    private static boolean isUpper(char c) {
        return Character.isUpperCase(c);
    }
}
