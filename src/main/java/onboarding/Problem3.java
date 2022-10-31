package onboarding;

import onboarding.problem3.Problem3Validation;

public class Problem3 {
    private static final int MIN_INPUT = 1;
    private static final int MAX_INPUT = 10000;

    private static final char THREE = '3';
    private static final char SIX = '6';
    private static final char NINE = '9';

    public static int solution(int number) {
        int result = 0;

        if (Problem3Validation.problem3InputValidation(number, MIN_INPUT, MAX_INPUT)) {
            result = getTotalClapHandsCount(number);
        }

        return result;
    }

    private static int getTotalClapHandsCount(int number) {
        int clapHandsCount = 0;
        for (int i = 1; i <= number; i++) {
            clapHandsCount += thisTurnClapCounts(i);
        }
        return clapHandsCount;
    }

    private static int thisTurnClapCounts(int number) {
        String numberString = Integer.toString(number);
        return (int) numberString.chars()
                .filter(numberChar -> numberChar == THREE || numberChar == SIX || numberChar == NINE)
                .count();

    }
}
