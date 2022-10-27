package onboarding.problem4.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AlphabetConverter {
    private static final List<Character> LOWERCASE_LETTERS = lowercaseLettersInit();
    
    private static List<Character> lowercaseLettersInit() {
        return IntStream.rangeClosed(0, 25)
                .mapToObj(number -> (char) (122 - number))
                .collect(Collectors.toList());
    }
}
