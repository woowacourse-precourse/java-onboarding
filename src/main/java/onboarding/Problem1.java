package onboarding;

import onboarding.problem1.Problem1Validation;

import java.util.List;

import static java.lang.Math.*;

class Problem1 {
    private final static int USER_INPUT_LENGTH = 2;
    private final static int PAGE_NUM_MIN = 1;
    private final static int PAGE_NUM_MAX = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (Problem1Validation.problem1InputValidation(pobi, USER_INPUT_LENGTH, PAGE_NUM_MIN, PAGE_NUM_MAX)
                && Problem1Validation.problem1InputValidation(crong, USER_INPUT_LENGTH, PAGE_NUM_MIN, PAGE_NUM_MAX)) {
            List<Integer> userResults = userResult(pobi, crong);
            return result(userResults.get(0), userResults.get(1));
        } else {
            return -1;
        }
    }



    private static int result(Integer user1Result, Integer user2Result) {
        if (user1Result > user2Result) {
            return 1;
        } else if (user1Result == user2Result) {
            return 0;
        } else {
            return 2;
        }
    }

    private static int getMaxValue(Integer integer1, Integer integer2) {
        return max(integer1, integer2);
    }

    private static int getDigitAddValue(int value) {
        int summation = 0;
        while (value > 0) {
            summation += value % 10;
            value /= 10;
        }
        return summation;
    }

    private static int getDigitMultiplyValue(int value) {
        int multiply = 1;
        while (value > 0) {
            multiply *= value % 10;
            value /= 10;
        }
        return multiply;
    }

    private static int chooseMaxValueBetweenAddAndMultiply(int value) {
        return getMaxValue(getDigitAddValue(value), getDigitMultiplyValue(value));
    }

    private static int chooseMaxValueLeftOrRight(List<Integer> pageList) {
        return getMaxValue(chooseMaxValueBetweenAddAndMultiply(pageList.get(0)), chooseMaxValueBetweenAddAndMultiply(pageList.get(1)));
    }

    private static List<Integer> userResult(List<Integer> user1, List<Integer> user2) {
        return List.of(chooseMaxValueLeftOrRight(user1), chooseMaxValueLeftOrRight(user2));
    }
}