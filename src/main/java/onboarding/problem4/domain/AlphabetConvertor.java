package onboarding.problem4.domain;

import onboarding.problem4.domain.strategy.AlphabetConvertStrategy;
import onboarding.problem4.domain.strategy.LowerCaseConvertStrategy;
import onboarding.problem4.domain.strategy.UpperCaseConvertStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class AlphabetConvertor {
    private static final Map<Character, Supplier<AlphabetConvertStrategy>> ALPHABET_CONVERTOR = new HashMap<>();
    private static final int MIN_NUMBER_OF_UPPER_CASE_ASCII_NUMBERS = 65;
    private static final int MAX_NUMBER_OF_UPPER_CASE_ASCII_NUMBERS = 90;
    private static final int MIN_NUMBER_OF_LOWER_CASE_ASCII_NUMBERS = 97;
    private static final int MAX_NUMBER_OF_LOWER_CASE_ASCII_NUMBERS = 122;
    
    static {
        IntStream.rangeClosed(MIN_NUMBER_OF_UPPER_CASE_ASCII_NUMBERS, MAX_NUMBER_OF_UPPER_CASE_ASCII_NUMBERS)
                .mapToObj(number -> (char) number)
                .forEach(character -> ALPHABET_CONVERTOR.put(character, UpperCaseConvertStrategy::new));
        
        IntStream.rangeClosed(MIN_NUMBER_OF_LOWER_CASE_ASCII_NUMBERS, MAX_NUMBER_OF_LOWER_CASE_ASCII_NUMBERS)
                .mapToObj(number -> (char) number)
                .forEach(character -> ALPHABET_CONVERTOR.put(character, LowerCaseConvertStrategy::new));
    }
    
    public static char convertAlphabet(final char alphabet) {
        return ALPHABET_CONVERTOR.get(alphabet)
                .get()
                .convert(alphabet);
    }
}
