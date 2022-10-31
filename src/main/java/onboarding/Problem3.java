package onboarding;

import java.util.stream.IntStream;

public class Problem3 {

    private static final int ZERO = 0;
    private static final int THREE = 3;
    private static final int DECIMAL = 10;

    public static int solution(int number) {
        return getTotalCount(number);
    }

    private static int getTotalCount(int number) {
        return IntStream.rangeClosed(1, number)
            .reduce(ZERO, (total, value) -> total + getCount(value));
    }

    private static int getCount(int number) {
        int count = ZERO;
        while (number > ZERO) {
            int placeNumber = number % DECIMAL;
            if (isDivisibleByThree(placeNumber)) {
                count++;
            }
            number /= DECIMAL;
        }
        return count;
    }

    private static boolean isDivisibleByThree(int placeNumber) {
        return placeNumber % THREE == ZERO && placeNumber != ZERO;
    }
}
