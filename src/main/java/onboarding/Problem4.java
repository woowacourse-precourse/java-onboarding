package onboarding;

import static onboarding.Problem4.AlphabetConst.LOWER_CASE_CHAR_A;
import static onboarding.Problem4.AlphabetConst.LOWER_CASE_CHAR_Z;
import static onboarding.Problem4.AlphabetConst.UPPER_CASE_CHAR_A;
import static onboarding.Problem4.AlphabetConst.UPPER_CASE_CHAR_Z;
import static onboarding.Problem4.CharacterValidator.isAlphabet;
import static onboarding.Problem4.CharacterValidator.isUpperCase;
import static onboarding.Problem4.WordCalculator.*;
import static onboarding.Problem4.WordConst.WORD_START_INDEX;

public class Problem4 {

    public static String solution(String word) {
        return calculateWord(word);
    }

    public static class WordCalculator {

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

    public static class CharacterValidator {

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

    public abstract class AlphabetConst {

        public static final char UPPER_CASE_CHAR_A = 'A';
        public static final char UPPER_CASE_CHAR_Z = 'Z';
        public static final char LOWER_CASE_CHAR_A = 'a';
        public static final char LOWER_CASE_CHAR_Z = 'z';
    }

    public abstract class WordConst {

        public static final int WORD_START_INDEX = 0;
    }
}
