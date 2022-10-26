package onboarding;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem4 {
    private static final List<Character> LOWERCASE_LETTERS = lowercaseLettersInit();
    private static final List<Character> UPPERCASE_LETTERS = uppercaseLettersInit();
    
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
    
    private static List<Character> lowercaseLettersInit() {
        return IntStream.rangeClosed(0, 25)
                .mapToObj(number -> (char) (122 - number))
                .collect(Collectors.toList());
    }
    
    private static List<Character> uppercaseLettersInit() {
        return IntStream.rangeClosed(0, 25)
                .mapToObj(number -> (char) (90 - number))
                .collect(Collectors.toList());
    }
    
    private static Character toConvertLowerCase(Character character) {
        return LOWERCASE_LETTERS.get(character - 'a');
    }
    
    private static Character toConvertUpperCase(Character character) {
        return UPPERCASE_LETTERS.get(character - 'A');
    }
}
