package onboarding;

import onboarding.problem3.Problem3Validation;

public class Problem3 {
    private static final int MIN_INPUT = 1;
    private static final int MAX_INPUT = 10000;
    public static int solution(int number) {
        if (Problem3Validation.problem3InputValidation(number, MIN_INPUT, MAX_INPUT)) {
            int clapHandsCount = 0;
            for (int i = 1; i <= number; i++) {
                clapHandsCount += thisTurnClapCounts(i);
            }
            return clapHandsCount;
        } else {
            return 0;
        }
    }

    private static int thisTurnClapCounts(int number) {
        return 0;
    }
}
