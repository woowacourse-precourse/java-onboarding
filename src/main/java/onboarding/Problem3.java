package onboarding;

import static onboarding.Problem3.CalculateClapCount.CALCULATE_REMAINDER_VALUE;
import static onboarding.Problem3.CalculateClapCount.DECIMAL_UNIT_VALUE;
import static onboarding.Problem3.ClapCacheConst.CHECK_CACHE_VALUE;
import static onboarding.Problem3.ClapNumberConst.CLAP_MAX_VALUE;
import static onboarding.Problem3.ClapNumberConst.CLAP_NINE;
import static onboarding.Problem3.ClapNumberConst.CLAP_SIX;
import static onboarding.Problem3.ClapNumberConst.CLAP_START_NUMBER;
import static onboarding.Problem3.ClapNumberConst.CLAP_THREE;
import static onboarding.Problem3.ClapNumberConst.CLAP_VALUE;
import static onboarding.Problem3.ClapNumberConst.NOT_CLAP_VALUE;

public class Problem3 {

    static int[] clapCountArr = new int[CLAP_MAX_VALUE + 1];

    public static int solution(int number) {
        return calculateTotalClapCount(number);
    }

    private static int calculateTotalClapCount(int number) {
        int totalClapCount = 0;

        for (int i = CLAP_START_NUMBER; i <= number; i++) {
            totalClapCount += calculateTargetClapCount(i);
        }

        return totalClapCount;
    }

    private static int calculateTargetClapCount(int target) {
        int clapCount = 0;

        while (target != CALCULATE_REMAINDER_VALUE) {
            int targetDigit = target % DECIMAL_UNIT_VALUE;
            target /= DECIMAL_UNIT_VALUE;

            if (isCached(targetDigit)) {
                clapCount += clapCountArr[targetDigit];
                continue;
            }
            clapCount += calculateTargetDigitClapCount(targetDigit);
        }
        return clapCount;
    }

    private static int calculateTargetDigitClapCount(int target) {
        if (isClapped(target)) {
            return clapCountArr[target] = clapCountArr[target] + CLAP_VALUE;
        }
        return NOT_CLAP_VALUE;
    }

    private static boolean isClapped(int target) {
        return target == CLAP_THREE || target == CLAP_SIX || target == CLAP_NINE;
    }

    private static boolean isCached(int target) {
        return clapCountArr[target] > CHECK_CACHE_VALUE;
    }

    public abstract class ClapNumberConst {

        public static final int CLAP_START_NUMBER = 1;
        public static final int CLAP_THREE = 3;
        public static final int CLAP_SIX = 6;
        public static final int CLAP_NINE = 9;
        public static final int CLAP_MAX_VALUE = 10000;
        public static final int NOT_CLAP_VALUE = 0;
        public static final int CLAP_VALUE = 1;
    }

    public abstract class ClapCacheConst {

        public static final int CHECK_CACHE_VALUE = 0;
    }

    public abstract class CalculateClapCount {

        public static final int DECIMAL_UNIT_VALUE = 10;
        public static final int CALCULATE_REMAINDER_VALUE = 0;
    }
}
