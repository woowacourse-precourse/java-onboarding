package onboarding.problem4.domain;

import onboarding.problem4.utils.AlphabetConvertor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence {
    private static final String CONVERTIBLE_CHARACTER_FORM = "[a-z|A-Z]";
    
    private final String sentence;
    
    public Sentence(final String sentence) {
        this.sentence = sentence;
    }
    
    public String convert() {
        final char[] chars = sentence.toCharArray();
        for (int index = 0; index < chars.length; index++) {
            chars[index] = convertCharacter(chars[index]);
        }
        
        return String.valueOf(chars);
    }
    
    private char convertCharacter(final char character) {
        if (isAlphabet(character)) {
            return AlphabetConvertor.convertAlphabet(character);
        }
        
        return character;
    }
    
    private static boolean isAlphabet(final char aChar) {
        final Matcher matcher = Pattern.compile(CONVERTIBLE_CHARACTER_FORM).matcher(String.valueOf(aChar));
        return matcher.matches();
    }
}
