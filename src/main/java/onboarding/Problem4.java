package onboarding;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem4 {
    private static final List<Character> LOWERCASE_LETTERS = lowercaseLettersInit();
    private static final List<Character> UPPERCASE_LETTERS = uppercaseLettersInit();
    
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
    
    public static String solution(String word) {
        String answer = "";
    
        final char[] chars = word.toCharArray();
        for (int index = 0; index < chars.length; index++) {
            if (isAlphabet(chars[index])) {
                chars[index] = toConvertAlphabet(chars[index]);
            }
        }
        
        return answer;
    }
    
    private static char toConvertAlphabet(final char aChar) {
        if (Character.isUpperCase(aChar)) {
            return toConvertUpperCase(aChar);
        }
        
        return toConvertLowerCase(aChar);
    }
    
    private static boolean isAlphabet(final char aChar) {
        final Matcher matcher = Pattern.compile("[a-z]|[A-Z]").matcher(String.valueOf(aChar));
        return matcher.matches();
    }
    
    private static Character toConvertLowerCase(Character character) {
        return LOWERCASE_LETTERS.get(character - 'a');
    }
    
    private static Character toConvertUpperCase(Character character) {
        return UPPERCASE_LETTERS.get(character - 'A');
    }
}
