package onboarding.problem3;

import java.util.stream.IntStream;

public class GameNumber {
    private final int maxRange;

    public GameNumber(int maxRange) {
        this.maxRange = maxRange;
        isIllegal();
    }

    private void isIllegal() {
        isNotNature();
        isOverMax();
    }

    private void isNotNature() {
        if (maxRange <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private void isOverMax() {
        if (maxRange > 10000) {
            throw new IllegalArgumentException();
        }
    }

    public IntStream getRange() {
        return IntStream.rangeClosed(1, maxRange);
    }
}
