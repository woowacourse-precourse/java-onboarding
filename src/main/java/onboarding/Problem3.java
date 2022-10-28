package onboarding;

import java.util.stream.IntStream;

public class Problem3 {
    private static final int MINIMUM_INPUT = 1;
    private static final int MAXIMUM_INPUT = 10000;
    private static final int INPUT_ERROR = -1;

    public static int solution(int number) {
        if (isExceptionInput(number)) return INPUT_ERROR;

        IntStream numbers = IntStream.rangeClosed(0, number);
        return numbers.reduce((x, y) -> x + getClapCount(y)).orElse(0);
    }

    private static boolean isExceptionInput(int number) {
        return number < MINIMUM_INPUT || number > MAXIMUM_INPUT;
    }

    private static int getClapCount(int num) {
        int clapCount = 0;

        while (num > 0) {
            int oneNum = num % 10;
            num /= 10;
            if (oneNum != 0 && oneNum % 3 == 0) clapCount++;
        }
        return clapCount;
    }

}