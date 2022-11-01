package onboarding.problem4.domain.strategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UpperCaseConvertStrategy implements AlphabetConvertStrategy {
    private static final List<Character> UPPERCASE_LETTERS = uppercaseLettersInit();
    private static final int MAX_NUMBER_OF_UPPER_CASE_ASCII_NUMBERS = 90;
    private static final int MAX_NUMBER_OF_NUMBER_TO_SUBTRACT = 25;
    private static final int MIN_NUMBER_OF_NUMBER_TO_SUBTRACT = 0;
    
    private static List<Character> uppercaseLettersInit() {
        return IntStream.rangeClosed(MIN_NUMBER_OF_NUMBER_TO_SUBTRACT, MAX_NUMBER_OF_NUMBER_TO_SUBTRACT)
                .mapToObj(number -> (char) (MAX_NUMBER_OF_UPPER_CASE_ASCII_NUMBERS - number))
                .collect(Collectors.toList());
    }
    
    @Override
    public char convert(final char alphabet) {
        return UPPERCASE_LETTERS.get(alphabet - 'A');
    }
}
