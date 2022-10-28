package onboarding.feature4;

import static onboarding.feature4.Constants.*;

import java.util.ArrayList;
import java.util.List;

import onboarding.feature4.AlphabetValidator;


public class Encryption {
    public static List<Character> encryptLetters(List<Character> givenLetters) {
        List<Character> lettersEncrypted = new ArrayList<>();
        for (Character letter : givenLetters) {
            if (AlphabetValidator.isUppercase(letter)) {
                letter = shiftLetter(UPPER_CASE, letter);
            }
            if (AlphabetValidator.isLowercase(letter)) {
                letter = shiftLetter(LOWER_CASE, letter);
            }
            lettersEncrypted.add(letter);
        }
        return lettersEncrypted;
    }

    public static Character shiftLetter(List<Character> letterCase, Character letter) {
        int indexOfLetter = letterCase.indexOf(letter);
        letter  = letterCase.get(SHIFT_AMOUNT - indexOfLetter);
        return letter;
    }
}
