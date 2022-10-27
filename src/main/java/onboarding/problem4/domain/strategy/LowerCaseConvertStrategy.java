package onboarding.problem4.domain.strategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LowerCaseConvertStrategy implements AlphabetConvertStrategy {
    private static final List<Character> LOWERCASE_LETTERS = lowercaseLettersInit();
    
    private static List<Character> lowercaseLettersInit() {
        return IntStream.rangeClosed(0, 25)
                .mapToObj(number -> (char) (122 - number))
                .collect(Collectors.toList());
    }
    
    @Override
    public char convert(final char alphabet) {
        return LOWERCASE_LETTERS.get(alphabet - 'a');
    }
}
