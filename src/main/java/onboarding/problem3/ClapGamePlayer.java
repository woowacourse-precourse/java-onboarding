package onboarding.problem3;

import static onboarding.problem3.consts.CalculateClapCountConst.CALCULATE_REMAINDER_VALUE;
import static onboarding.problem3.consts.CalculateClapCountConst.DECIMAL_UNIT_VALUE;
import static onboarding.problem3.consts.ClapCacheConst.CHECK_CACHE_VALUE;
import static onboarding.problem3.consts.ClapGameConst.CLAP_GAME_NUMBER_MAX_VALUE;
import static onboarding.problem3.consts.ClapGameConst.CLAP_GAME_START_NUMBER;
import static onboarding.problem3.consts.ClapNumberConst.CLAP_NINE;
import static onboarding.problem3.consts.ClapNumberConst.CLAP_SIX;
import static onboarding.problem3.consts.ClapNumberConst.CLAP_THREE;
import static onboarding.problem3.consts.ClapNumberConst.CLAP_VALUE;
import static onboarding.problem3.consts.ClapNumberConst.NOT_CLAPPED_VALUE;

public class ClapGamePlayer {

    private static final int[] clapCountArr = new int[CLAP_GAME_NUMBER_MAX_VALUE + 1];

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
            clapCount += calculateCachedClapCount(targetDigit);
        }
        return clapCount;
    }

    private static int calculateCachedClapCount(int targetDigit) {
        if (isCached(targetDigit)) {
            return clapCountArr[targetDigit];
        }
        return calculateTargetDigitClapCount(targetDigit);
    }

    private static int calculateTargetDigitClapCount(int target) {
        if (isClapped(target)) {
            return clapCountArr[target] = clapCountArr[target] + CLAP_VALUE;
        }
        return NOT_CLAPPED_VALUE;
    }

    private static boolean isClapped(int target) {
        return target == CLAP_THREE || target == CLAP_SIX || target == CLAP_NINE;
    }

    private static boolean isCached(int target) {
        return clapCountArr[target] > CHECK_CACHE_VALUE;
    }
}
