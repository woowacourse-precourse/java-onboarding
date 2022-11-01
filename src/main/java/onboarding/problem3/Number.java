package onboarding.problem3;

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
}
