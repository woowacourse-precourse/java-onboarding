package onboarding.problem3;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Applause {
    public static int start(int number) {
        String numbers = joinNumbers(number);
        int clap = 0;
        for (int i = 0; i < numbers.length(); i++) {
            clap = addClap(numbers, clap, i);
        }
        return clap;
    }

    private static int addClap(String numbers, int count, int i) {
        if (isClap(numbers, i)) {
            count++;
        }
        return count;
    }

    private static String joinNumbers(int number) {
        return IntStream.range(1, number + 1).mapToObj(String::valueOf).collect(Collectors.joining());
    }

    private static boolean isClap(String string, int i) {
        return string.charAt(i) == '3' || string.charAt(i) == '6' || string.charAt(i) == '9';
    }

}
