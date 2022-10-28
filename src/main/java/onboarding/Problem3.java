package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Problem3 {
    private static final List<Integer> numbers = Arrays.asList(3, 6, 9);
    private static int count;

    public static int solution(int number) {
        count = 0;
        IntStream.range(1, number + 1).forEach(Problem3::checkEachDigitInNumber);
        return count;
    }

    private static void checkEachDigitInNumber(int number) {
        while (number != 0) {
            if (numbers.contains(number % 10)) {
                count++;
            }

            number /= 10;
        }
    }
}
