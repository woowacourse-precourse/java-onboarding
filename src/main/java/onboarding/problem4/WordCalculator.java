package onboarding.problem4;

import static onboarding.problem4.CharacterValidator.isAlphabet;
import static onboarding.problem4.CharacterValidator.isUpperCase;
import static onboarding.problem4.consts.AlphabetConst.LOWER_CASE_CHAR_A;
import static onboarding.problem4.consts.AlphabetConst.LOWER_CASE_CHAR_Z;
import static onboarding.problem4.consts.AlphabetConst.UPPER_CASE_CHAR_A;
import static onboarding.problem4.consts.AlphabetConst.UPPER_CASE_CHAR_Z;
import static onboarding.problem4.consts.WordConst.WORD_START_INDEX;

public class WordCalculator {

    private WordCalculator() {
    }

    public static String calculateWord(String word) {
        char[] wordCharacters = word.toCharArray();

        for (int i = WORD_START_INDEX; i < wordCharacters.length; i++) {
            wordCharacters[i] = changeCharacter(wordCharacters[i]);
        }
        return String.valueOf(wordCharacters);
    }

    private static char changeCharacter(char target) {
        if (!isAlphabet(target)) {
            return target;
        }
        if (isUpperCase(target)) {
            return calculateCharacter(UPPER_CASE_CHAR_A, UPPER_CASE_CHAR_Z, target);
        }
        return calculateCharacter(LOWER_CASE_CHAR_A, LOWER_CASE_CHAR_Z, target);
    }

    private static char calculateCharacter(char standardA, char standardZ, char target) {
        return (char) (standardA + (standardZ - target));
    }
}
