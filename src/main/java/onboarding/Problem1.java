package onboarding;

import onboarding.problem1Validation.Problem1Validation;

import java.util.List;

import static java.lang.Math.*;

class Problem1 {
    private final static int USER_INPUT_LENGTH = 2;
    private final static int PAGE_NUM_MIN = 1;
    private final static int PAGE_NUM_MAX = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (Problem1Validation.problem1InputValidation(pobi, USER_INPUT_LENGTH, PAGE_NUM_MIN, PAGE_NUM_MAX)
                && Problem1Validation.problem1InputValidation(crong, USER_INPUT_LENGTH, PAGE_NUM_MIN, PAGE_NUM_MAX)) {
            int answer = Integer.MAX_VALUE;
            return answer;
        } else {
            return -1;
        }
    }



    public static int result(Integer user1Result, Integer user2Result) {
        if (user1Result > user2Result) {
            return 1;
        } else if (user1Result == user2Result) {
            return 0;
        } else {
            return 2;
        }
    }

    public static int getMaxValue(Integer integer1, Integer integer2) {
        return max(integer1, integer2);
    }

    public static int getDigitAddValue(int value) {
        int summation = 0;
        while (value > 0) {
            summation += value % 10;
            value /= 10;
        }
        return summation;
    }

    public static int getDigitMultiplyValue(int value) {
        int multiply = 1;
        while (value > 0) {
            multiply *= value % 10;
            value /= 10;
        }
        return multiply;
    }

    public static int chooseMaxValueBetweenAddAndMultiply(int value) {
        return getMaxValue(getDigitAddValue(value), getDigitMultiplyValue(value));
    }

    public static int chooseMaxValueLeftOrRight(List<Integer> pageList) {
        return getMaxValue(chooseMaxValueBetweenAddAndMultiply(pageList.get(0)), chooseMaxValueBetweenAddAndMultiply(pageList.get(1)));
    }

}