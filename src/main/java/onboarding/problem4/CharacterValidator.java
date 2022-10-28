package onboarding.problem4;

import static onboarding.problem4.consts.AlphabetConst.LOWER_CASE_CHAR_A;
import static onboarding.problem4.consts.AlphabetConst.LOWER_CASE_CHAR_Z;
import static onboarding.problem4.consts.AlphabetConst.UPPER_CASE_CHAR_A;
import static onboarding.problem4.consts.AlphabetConst.UPPER_CASE_CHAR_Z;

public class CharacterValidator {

    public static boolean isAlphabet(char target) {
        return isUpperCase(target) || isLowerCase(target);
    }

    public static boolean isUpperCase(char target) {
        return UPPER_CASE_CHAR_A <= target && target <= UPPER_CASE_CHAR_Z;
    }

    public static boolean isLowerCase(char target) {
        return LOWER_CASE_CHAR_A <= target && target <= LOWER_CASE_CHAR_Z;
    }
}
