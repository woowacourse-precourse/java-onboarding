package onboarding.problem5;

import onboarding.problem5.exception.OverflowNumberException;

public class InputNumberValidator {
    private static final int MIN_INPUT_NUMBER_SIZE = 1;
    private static final int MAX_INPUT_NUMBER_SIZE = 1_000_000;

    public void validate(int inputNumber) {
        if(!isSatisfiedInputNumSize(inputNumber)) {
            throw new OverflowNumberException();
        }
    }

    public boolean isSatisfiedInputNumSize(int inputNumber) {
        return inputNumber >= MIN_INPUT_NUMBER_SIZE && inputNumber <= MAX_INPUT_NUMBER_SIZE;
    }
}
