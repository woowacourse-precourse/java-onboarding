package onboarding;

import static onboarding.problem3.CountNumber.getCount;
import static onboarding.problem3.Validation.isOutOfRange;

public class Problem3 {

    private static final int OUT_OF_RANGE = -1;

    public static int solution(int number) {
        if (isOutOfRange(number)) {
            return OUT_OF_RANGE;
        }

        return getCount(number);
    }
}
