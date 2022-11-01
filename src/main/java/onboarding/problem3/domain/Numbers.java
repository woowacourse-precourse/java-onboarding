package onboarding.problem3.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Numbers {
    private static final int START_NUMBER = 1;
    
    private final List<Number> numbers;
    
    public Numbers(final int maxNumber) {
        this(initNumbers(maxNumber));
    }
    
    public Numbers(final List<Number> numbers) {
        this.numbers = numbers;
    }
    
    private static List<Number> initNumbers(final int maxNumber) {
        return IntStream.rangeClosed(START_NUMBER, maxNumber)
                .mapToObj(Number::new)
                .collect(Collectors.toList());
    }
    
    public int sumCountOfMultipleOfThree() {
        return numbers.stream()
                .mapToInt(Number::countOfMultipleOfThree)
                .sum();
    }
}
