package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Problem3 {

    private static final String THREE = "3";
    private static final String SIX = "6";
    private static final String NINE = "9";
    private static final int START_NUM = 1;
    private static final int NUM_MIN = 1;
    private static final int NUM_MAX = 10000;

    public static int solution(int number) {
        validateNum(number);
        return IntStream.rangeClosed(START_NUM, number)
            .map(Problem3::computeClapCount)
            .reduce((clapCount1, clapCount2) -> clapCount1 + clapCount2)
            .getAsInt();
    }

    private static void validateNum(int number) {
        if (number < NUM_MIN || number > NUM_MAX) {
            throw new IllegalArgumentException();
        }
    }

    private static int computeClapCount(int num) {
        List<String> only369 = List.of(THREE, SIX, NINE);

        return (int) Arrays.stream(String.valueOf(num)
                .split(""))
            .filter(n -> only369.contains(n))
            .count();
    }
}
