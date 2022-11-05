package onboarding.problem4;

import static java.lang.Character.*;
import static onboarding.problem4.Alphabet.*;

public class WordConverter {

    public String convertWord(String word) {
        StringBuilder convertedWord = new StringBuilder(word.length());
        for (char letter : word.toCharArray()) {
            char convertedCharacter = convertWithDictionary(letter);
            convertedWord.append(convertedCharacter);
        }
        return convertedWord.toString();
    }

    private char convertWithDictionary(char letter) {
        if (isUpperCase(letter))
            return (char) (ALPHABET_UPPERCASE_END.getLetter()- (letter - ALPHABET_UPPERCASE_START.getLetter()));
        if (isLowerCase(letter))
            return (char) (ALPHABET_LOWERCASE_END.getLetter() - (letter - ALPHABET_LOWERCASE_START.getLetter()));
        return letter;
    }
}
