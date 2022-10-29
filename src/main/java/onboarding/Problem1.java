package onboarding;

import onboarding.problem1.Problem1Validation;

import java.util.List;

import static java.lang.Math.*;

class Problem1 {
    private static final int USER_INPUT_LENGTH = 2;
    private static final int PAGE_NUM_MIN = 1;
    private static final int PAGE_NUM_MAX = 400;
    private static final int LEFT_IDX = 0;
    private static final int RIGHT_IDX = 1;
    private static final int USER_1_WIN = 1;
    private static final int USER_2_WIN = 2;
    private static final int DRAW = 0;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int result = -1;

        if (Problem1Validation.problem1InputValidation(pobi, USER_INPUT_LENGTH, PAGE_NUM_MIN, PAGE_NUM_MAX)
                && Problem1Validation.problem1InputValidation(crong, USER_INPUT_LENGTH, PAGE_NUM_MIN, PAGE_NUM_MAX)) {
            List<Integer> userResults = getUserResults(pobi, crong);
            result = chooseWinnerResult(userResults.get(0), userResults.get(1));
        }

        return result;
    }

    private static List<Integer> getUserResults(List<Integer> user1, List<Integer> user2) {
        return List.of(chooseMaxValueLeftOrRight(user1), chooseMaxValueLeftOrRight(user2));
    }

    private static int chooseMaxValueLeftOrRight(List<Integer> pageList) {
        return max(chooseMaxValueBetweenAddAndMultiply(pageList.get(LEFT_IDX)), chooseMaxValueBetweenAddAndMultiply(pageList.get(RIGHT_IDX)));
    }

    private static int chooseMaxValueBetweenAddAndMultiply(int value) {
        return max(getDigitAddValue(value), getDigitMultiplyValue(value));
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



    private static int chooseWinnerResult(Integer user1Result, Integer user2Result) {
        int result = -1;

        if (user1Result > user2Result) {
            result = USER_1_WIN;
        } else if (user1Result == user2Result) {
            result = DRAW;
        } else if (user1Result < user2Result) {
            result = USER_2_WIN;
        }

        return result;
    }
}