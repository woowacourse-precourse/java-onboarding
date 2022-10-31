package onboarding.problem3;

import static onboarding.common.consts.CommonDigitNumberConst.CALCULATE_REMAINDER_VALUE;
import static onboarding.common.consts.CommonDigitNumberConst.DECIMAL_UNIT_VALUE;
import static onboarding.problem3.consts.ClapGameConst.*;

/**
 * 3, 6, 9 게임을 진행하고 결과를 반환하는 클래스
 */
public class ClapGamePlayer {

    /**
     * new 연산자를 통한 생성을 방지하기 위한 private 기본 생성자
     */
    private ClapGamePlayer() {
    }

    /**
     * 3, 6, 9 게임에서 게임의 목표 값까지 총 박수 횟수를 구하는 메소드
     *
     * @param number 게임의 목표 값
     * @return 총 박수 횟수
     */
    public static int calculateTotalClapCount(int number) {
        int totalClapCount = 0;

        for (int i = CLAP_GAME_START_VALUE; i <= number; i++) {
            totalClapCount += calculateTargetClapCount(i);
        }
        return totalClapCount;
    }

    /**
     * 주어진 숫자에서 박수를 몇 번 쳐야하는지 구하는 메소드
     *
     * @param target 박수를 몇 번 쳐야하는지 구해야 하는 숫자
     * @return 박수 횟수
     */
    private static int calculateTargetClapCount(int target) {
        int clapCount = 0;

        while (target != CALCULATE_REMAINDER_VALUE) {
            int targetDigit = target % DECIMAL_UNIT_VALUE;
            target /= DECIMAL_UNIT_VALUE;
            clapCount += calculateTargetDigitClapCount(targetDigit);
        }
        return clapCount;
    }

    /**
     * 주어진 자릿수에서 박수를 친 횟수를 반환하는 메소드
     *
     * @param targetDigit 자릿수
     * @return 박수를 친 횟수(0, 1)
     */
    private static int calculateTargetDigitClapCount(int targetDigit) {
        if (isClapped(targetDigit)) {
            return CLAPPED_VALUE;
        }
        return NOT_CLAPPED_VALUE;
    }

    /**
     * 주어진 자릿수가 박수를 쳐야하는지 유뮤를 검증하는 메소드
     *
     * @param targetDigit 자릿수
     * @return 박수를 칠 것인지에 대한 유무
     */
    private static boolean isClapped(int targetDigit) {
        return targetDigit == CLAP_THREE_VALUE || targetDigit == CLAP_SIX_VALUE
            || targetDigit == CLAP_NINE_VALUE;
    }
}
