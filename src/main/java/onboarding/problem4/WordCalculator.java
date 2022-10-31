package onboarding.problem4;

import static java.lang.Character.*;
import static onboarding.problem4.consts.AlphabetConst.LOWER_CASE_CHAR_A;
import static onboarding.problem4.consts.AlphabetConst.LOWER_CASE_CHAR_Z;
import static onboarding.problem4.consts.AlphabetConst.UPPER_CASE_CHAR_A;
import static onboarding.problem4.consts.AlphabetConst.UPPER_CASE_CHAR_Z;
import static onboarding.problem4.consts.WordConst.WORD_START_INDEX;

/**
 * 단어를 변경하는 기능을 제공하는 클래스
 */
public class WordCalculator {

    /**
     * new 연산자를 통한 생성을 방지하기 위한 private 기본 생성자
     */
    private WordCalculator() {
    }

    /**
     * 문자열에서 알파벳만을 규칙에 따라 변경하는 메소드
     *
     * @param word 변경할 문자열
     * @return 변경한 문자열
     */
    public static String calculateWord(String word) {
        char[] wordCharacters = word.toCharArray();

        for (int i = WORD_START_INDEX; i < wordCharacters.length; i++) {
            wordCharacters[i] = changeCharacter(wordCharacters[i]);
        }
        return String.valueOf(wordCharacters);
    }

    /**
     * 대문자, 소문자를 판별해 문자를 변경하는 메소드
     *
     * @param target 변경할 문자
     * @return 변경한 문자
     */
    private static char changeCharacter(char target) {
        if (!isAlphabetic(target)) {
            return target;
        }
        if (isUpperCase(target)) {
            return calculateCharacter(UPPER_CASE_CHAR_A, UPPER_CASE_CHAR_Z, target);
        }
        return calculateCharacter(LOWER_CASE_CHAR_A, LOWER_CASE_CHAR_Z, target);
    }

    /**
     * 주어진 문자를 변경하는 메소드
     *
     * @param standardA 알파벳 A 혹은 a
     * @param standardZ 알파벳 Z 혹은 z
     * @param target    변경할 문자
     * @return 변경한 문자
     */
    private static char calculateCharacter(char standardA, char standardZ, char target) {
        return (char) (standardA + (standardZ - target));
    }
}
