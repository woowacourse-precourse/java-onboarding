package onboarding;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem3 {
    public static int solution(int number) {
        return IntStream.rangeClosed(1, number)
                .map(Problem3::countOfThreeSixNine)
                .reduce(0, Integer::sum);
    }
    
    private static int countOfThreeSixNine(int number) {
        return (int) Arrays.stream(split(number))
                .mapToInt(Integer::parseInt)
                .filter(eachDigit -> eachDigit != 0 && eachDigit % 3 == 0)
                .count();
    }
    
    private static String[] split(final int number) {
        return String.valueOf(number).split("");
    }
}
