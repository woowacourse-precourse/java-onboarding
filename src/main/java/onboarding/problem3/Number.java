package onboarding.problem3;

import java.util.Arrays;

public class Number {

    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 10_000;

    private int number;

    public Number(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if (isOutOfBounds(number)) throw new IllegalArgumentException("number is out of bounds");
    }

    private boolean isOutOfBounds(int number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }

    private static int[] toDigits(String s) {
        return Arrays.stream(s.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static boolean isClap(int n) {
        return n == 3 || n == 6 || n == 9;
    }
}
