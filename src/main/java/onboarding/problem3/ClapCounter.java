package onboarding.problem3;

public class ClapCounter {
    private static final int CONSTANT_THREE = 3;
    private static final int CONSTANT_SIX = 6;
    private static final int CONSTANT_NINE = 9;

    private int clapCount;
    private int maxRangeValue;

    public ClapCounter(int maxRangeValue) {
        this.clapCount = 0;
        this.maxRangeValue = maxRangeValue;
    }

    public int count() {
        for (int number = 1; number <= maxRangeValue; number++) {
            this.clapCount += countSatisfiedDigit(number);
        }
        return this.clapCount;
    }

    private boolean isSatisfy369Rules(int digit) {
        return digit == CONSTANT_THREE || digit == CONSTANT_SIX || digit == CONSTANT_NINE;
    }

    private int countSatisfiedDigit(int number) {
        int count = 0;
        while (number > 0) {
            if (isSatisfy369Rules(number % 10)) count++;
            number /= 10;
        }
        return count;
    }
}
