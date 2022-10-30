package onboarding.problem3;

import static onboarding.common.consts.CommonDigitNumberConst.CALCULATE_REMAINDER_VALUE;
import static onboarding.common.consts.CommonDigitNumberConst.DECIMAL_UNIT_VALUE;
import static onboarding.problem3.consts.ClapGameConst.*;

public class ClapGamePlayer {

    private ClapGamePlayer() {
    }

    public static int calculateTotalClapCount(int number) {
        int totalClapCount = 0;

        for (int i = CLAP_GAME_START_VALUE; i <= number; i++) {
            totalClapCount += calculateTargetClapCount(i);
        }
        return totalClapCount;
    }

    private static int calculateTargetClapCount(int target) {
        int clapCount = 0;

        while (target != CALCULATE_REMAINDER_VALUE) {
            int targetDigit = target % DECIMAL_UNIT_VALUE;
            target /= DECIMAL_UNIT_VALUE;
            clapCount += calculateTargetDigitClapCount(targetDigit);
        }
        return clapCount;
    }

    private static int calculateTargetDigitClapCount(int targetDigit) {
        if (isClapped(targetDigit)) {
            return CLAPPED_VALUE;
        }
        return NOT_CLAPPED_VALUE;
    }

    private static boolean isClapped(int targetDigit) {
        return targetDigit == CLAP_THREE_VALUE || targetDigit == CLAP_SIX_VALUE || targetDigit == CLAP_NINE_VALUE;
    }
}
