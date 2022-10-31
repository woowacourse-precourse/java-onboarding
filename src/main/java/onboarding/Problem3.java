package onboarding;

import java.util.stream.IntStream;

public class Problem3 {
    private static final int START_NUMBER = 1;

    private static final int CLAP_THREE = 3;
    private static final int CLAP_SIX = 6;
    private static final int CLAP_NINE = 9;

    public static int solution(int number) {
        return IntStream.range(START_NUMBER, number + 1)
                .map(Problem3::countClap)
                .sum();
    }

    private static int countClap(int number) {
        int result = 0;

        while (number != 0) {
            int digit = number % 10;
            if (includeOneOf369(digit)) {
                result += 1;
            }
            number /= 10;
        }

        return result;
    }

    private static boolean includeOneOf369(int digit) {
        return digit == CLAP_THREE || digit == CLAP_SIX || digit == CLAP_NINE;
    }
}
