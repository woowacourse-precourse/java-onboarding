package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        answer = convertReverse(word);

        return answer;
    }

    public static String convertReverse(String inputString) {
        IntStream inputIntStream = inputString.chars();
        List<Character> resultList = new ArrayList<>();
        String result;

        inputIntStream.forEach(x -> {
            if (isUppercase(x)) {
                resultList.add(convertUppercase(x));
            } else if (isLowercase(x)) {
                resultList.add(convertLowercase(x));
            } else {
                resultList.add((char) x);
            };
        });

        result = resultList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        return result;
    }

    public static boolean isUppercase(int intValue) {
        if (!('A' <= intValue && intValue <= 'Z')) {
            return false;
        }

        return true;
    }

    public static boolean isLowercase(int intValue) {
        if (!('a' <= intValue && intValue <= 'z')) {
            return false;
        }

        return true;
    }

    public static char convertUppercase(int intValue) {
        char result = (char) ('Z' - intValue + 'A');

        return result;
    }

    public static char convertLowercase(int intValue) {
        char result = (char) ('z' - intValue + 'a');

        return result;
    }
}
