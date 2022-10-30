package onboarding.problem1;

import onboarding.problem1.exception.InputOutOfSizeException;

import java.util.List;

public class InputValidator {
    private final int MAX_INPUT_SIZE = 2;
    
    public void validate(List<Integer> input) {
        if(isOverflow(input)) {
            throw new InputOutOfSizeException();
        }
    }
    private boolean isOverflow(List<Integer> input) {
        return input.size() > MAX_INPUT_SIZE;
    }
}
