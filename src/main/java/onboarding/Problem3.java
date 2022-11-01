package onboarding;

import java.util.stream.IntStream;

public class Problem3 {

    private static final int ZERO = 0;
    private static final int THREE = 3;

    public static int solution(int number) {
        return getTotalCount(number);
    }

    private static int getTotalCount(int number) {
        return IntStream.rangeClosed(1, number)
            .map(Problem3::getCount)
            .sum();
    }

    private static int getCount(int number) {
        return (int) String.valueOf(number)
            .chars()
            .map(Character::getNumericValue)
            .filter(Problem3::isDivisibleByThree)
            .count();
    }

    private static boolean isDivisibleByThree(int placeNumber) {
        return placeNumber % THREE == ZERO && placeNumber != ZERO;
    }
}
