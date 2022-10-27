package onboarding.problem3.domain;

import java.util.Arrays;

public class Number {
    private final int number;
    
    public Number(final int number) {
        this.number = number;
    }
    
    public int countOfMultipleOfThree() {
        return (int) Arrays.stream(String.valueOf(number).split(""))
                .mapToInt(Integer::parseInt)
                .filter(this::isContainsThreeSixNine)
                .count();
    }
    
    private boolean isContainsThreeSixNine(final int digit) {
        return isNotZero(digit) && isMultipleOfThree(digit);
    }
    
    private boolean isMultipleOfThree(final int digit) {
        return digit % 3 == 0;
    }
    
    private boolean isNotZero(final int digit) {
        return digit != 0;
    }
}
