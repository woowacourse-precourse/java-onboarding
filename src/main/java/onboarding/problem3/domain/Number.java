package onboarding.problem3.domain;

import java.util.Arrays;

public class Number {
    private static final String DELIMITER = "";
    
    private final int number;
    
    public Number(final int number) {
        this.number = number;
    }
    
    public int countOfMultipleOfThree() {
        return (int) Arrays.stream(splitToString())
                .mapToInt(Integer::parseInt)
                .filter(this::isContainsThreeSixNine)
                .count();
    }
    
    private String[] splitToString() {
        final String stringNumber = String.valueOf(number);
        return stringNumber.split(DELIMITER);
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
