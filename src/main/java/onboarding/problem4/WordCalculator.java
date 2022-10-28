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
        char[] chars = word.toCharArray();
        char standardA;
        char standardZ;

        for (int i = WORD_START_INDEX; i < chars.length; i++) {
            if (!isAlphabet(chars[i])) {
                continue;
            }
            standardA = LOWER_CASE_CHAR_A;
            standardZ = LOWER_CASE_CHAR_Z;
            if (isUpperCase(chars[i])) {
                standardA = UPPER_CASE_CHAR_A;
                standardZ = UPPER_CASE_CHAR_Z;
            }
            chars[i] = calculateCharacter(standardA, standardZ, chars[i]);
        }
        return String.valueOf(chars);
    }

    private static char calculateCharacter(char standardA, char standardZ, char target) {
        return (char) (standardA + (standardZ - target));
    }
}
