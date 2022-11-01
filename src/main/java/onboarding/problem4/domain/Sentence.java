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
        final char[] sentenceCharacters = sentence.toCharArray();
        for (int index = 0; index < sentenceCharacters.length; index++) {
            sentenceCharacters[index] = convertCharacter(sentenceCharacters[index]);
        }
        
        return String.valueOf(sentenceCharacters);
    }
    
    private char convertCharacter(final char character) {
        if (isAlphabet(character)) {
            return AlphabetConvertor.convertAlphabet(character);
        }
        
        return character;
    }
    
    private static boolean isAlphabet(final char character) {
        final Pattern pattern = Pattern.compile(CONVERTIBLE_CHARACTER_FORM);
        final Matcher matcher = pattern.matcher(String.valueOf(character));
        return matcher.matches();
    }
}
