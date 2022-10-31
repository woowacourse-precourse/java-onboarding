package onboarding.problem4;

import static onboarding.problem4.consts.AlphabetConst.LOWER_CASE_CHAR_A;
import static onboarding.problem4.consts.AlphabetConst.LOWER_CASE_CHAR_Z;
import static onboarding.problem4.consts.AlphabetConst.UPPER_CASE_CHAR_A;
import static onboarding.problem4.consts.AlphabetConst.UPPER_CASE_CHAR_Z;

/**
 * 문자를 검증하는 기능을 제공하는 클래스
 */
public class CharacterValidator {

    /**
     * new 연산자를 통한 생성을 방지하기 위한 private 기본 생성자
     */
    private CharacterValidator() {
    }

    /**
     * 해당 문자가 알파벳인지 검증하는 메소드
     *
     * @param target 알파벳인지 검증할 문자
     * @return 알파벳이 맞는지에 대한 유무
     */
    public static boolean isAlphabet(char target) {
        return isUpperCase(target) || isLowerCase(target);
    }

    /**
     * 해당 문자가 알파벳 대문자인지 검증하는 메소드
     *
     * @param target 알파벳 대문자인지 검증할 문자
     * @return 알파벳 대문자가 맞는지에 대한 유무
     */
    public static boolean isUpperCase(char target) {
        return UPPER_CASE_CHAR_A <= target && target <= UPPER_CASE_CHAR_Z;
    }

    /**
     * 해당 문자가 알파벳 소문자인지 검증하는 메소드
     *
     * @param target 알파벳 소문자인지 검증할 문자
     * @return 알파벳 대문자가 맞는지에 대한 유무
     */
    public static boolean isLowerCase(char target) {
        return LOWER_CASE_CHAR_A <= target && target <= LOWER_CASE_CHAR_Z;
    }
}
