package onboarding.problem4.domain.strategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UpperCaseConvertStrategy implements AlphabetConvertStrategy {
    private static final List<Character> UPPERCASE_LETTERS = uppercaseLettersInit();
    
    private static List<Character> uppercaseLettersInit() {
        return IntStream.rangeClosed(0, 25)
                .mapToObj(number -> (char) (90 - number))
                .collect(Collectors.toList());
    }
    
    @Override
    public char convert(final char alphabet) {
        return UPPERCASE_LETTERS.get(alphabet - 'A');
    }
}
