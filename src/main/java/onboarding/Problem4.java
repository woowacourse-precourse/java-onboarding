package onboarding;

import static onboarding.Problem4.CharacterValidator.isAlphabet;
import static onboarding.Problem4.CharacterValidator.isUpperCase;

public class Problem4 {

    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static String calculateWord(String word) {
        char[] chars = word.toCharArray();
        char standardA;
        char standardZ;

        for (int i = 0; i < chars.length; i++) {
            if (!isAlphabet(chars[i])) {
                continue;
            }
            standardA = 'a';
            standardZ = 'z';
            if (isUpperCase(chars[i])) {
                standardA = 'A';
                standardZ = 'Z';
            }
            chars[i] = calculateCharacter(standardA, standardZ, chars[i]);
        }
        return String.valueOf(chars);
    }

    private static char calculateCharacter(char standardA, char standardZ, char target) {
        return (char) (standardA + (standardZ - target));
    }

    public static class CharacterValidator {

        public static boolean isAlphabet(char target) {
            return isUpperCase(target) || isLowerCase(target);
        }

        public static boolean isUpperCase(char target) {
            return 'A' <= target && target <= 'Z';
        }

        public static boolean isLowerCase(char target) {
            return 'a' <= target && target <= 'z';
        }
    }
}
