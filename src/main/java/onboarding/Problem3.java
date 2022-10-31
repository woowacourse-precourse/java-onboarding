package onboarding;

import java.util.stream.IntStream;

public class Problem3 {

    private static final int THREE = 3;
    private static final int TEN = 10;

    public static int solution(int number) {
        return IntStream.rangeClosed(1, number)
            .reduce(0,(total, value) -> total + getCount(value));
    }

    private static int getCount(int number) {
        int count = 0;
        while (number > 0) {
            int placeNumber = number % TEN;
            if (isThreeSixNine(placeNumber)) {
                count++;
            }
            number /= TEN;
        }
        return count;
    }

    private static boolean isThreeSixNine(int placeNumber) {
        return placeNumber % THREE == 0 && placeNumber != 0;
    }
}
