package onboarding.problem3;

import onboarding.problem3.exception.NumberOutOfSizeException;

public class InputNumberValidator {
    private static final int MIN_INPUT_NUMBER_SIZE = 1;
    private static final int MAX_INPUT_NUMBER_SIZE = 10_000;

    public void validate(int inputNumber) {
        if(!isSatisfiedInputNumSize(inputNumber)) {
            throw new NumberOutOfSizeException();
        }
    }

    public boolean isSatisfiedInputNumSize(int inputNumber) {
        return inputNumber >= MIN_INPUT_NUMBER_SIZE && inputNumber <= MAX_INPUT_NUMBER_SIZE;
    }
}
