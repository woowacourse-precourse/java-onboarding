package onboarding.problem3;

import java.util.stream.IntStream;

import static onboarding.problem3.ConstantsP3.INPUT_MAX_NUMBER;
import static onboarding.problem3.ConstantsP3.INPUT_MIN_NUMBER;

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
        if (maxRange < INPUT_MIN_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private void isOverMax() {
        if (maxRange > INPUT_MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public IntStream getRange() {
        return IntStream.rangeClosed(1, maxRange);
    }
}
