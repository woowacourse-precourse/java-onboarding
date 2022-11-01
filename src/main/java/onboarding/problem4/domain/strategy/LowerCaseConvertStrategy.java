package onboarding.problem4.domain.strategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LowerCaseConvertStrategy implements AlphabetConvertStrategy {
    private static final List<Character> LOWERCASE_LETTERS = lowercaseLettersInit();
    private static final int MAX_NUMBER_OF_LOWER_CASE_ASCII_NUMBERS = 122;
    private static final int MAX_NUMBER_OF_NUMBER_TO_SUBTRACT = 25;
    private static final int MIN_NUMBER_OF_NUMBER_TO_SUBTRACT = 0;
    
    private static List<Character> lowercaseLettersInit() {
        return IntStream.rangeClosed(MIN_NUMBER_OF_NUMBER_TO_SUBTRACT, MAX_NUMBER_OF_NUMBER_TO_SUBTRACT)
                .mapToObj(numberToSubtract -> (char) (MAX_NUMBER_OF_LOWER_CASE_ASCII_NUMBERS - numberToSubtract))
                .collect(Collectors.toList());
    }
    
    @Override
    public char convert(final char alphabet) {
        return LOWERCASE_LETTERS.get(alphabet - 'a');
    }
}
