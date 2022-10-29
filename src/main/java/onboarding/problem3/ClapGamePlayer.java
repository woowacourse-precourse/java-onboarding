package onboarding.problem3;

import static onboarding.common.consts.DigitNumberCommonConst.CALCULATE_REMAINDER_VALUE;
import static onboarding.common.consts.DigitNumberCommonConst.DECIMAL_UNIT_VALUE;
import static onboarding.problem3.consts.ClapGameConst.*;

public class ClapGamePlayer {

    public static int calculateTotalClapCount(int number) {
        int totalClapCount = 0;

        for (int i = CLAP_GAME_START_NUMBER; i <= number; i++) {
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
            return CLAP_VALUE;
        }
        return NOT_CLAPPED_VALUE;
    }

    private static boolean isClapped(int targetDigit) {
        return targetDigit == CLAP_THREE || targetDigit == CLAP_SIX || targetDigit == CLAP_NINE;
    }
}
