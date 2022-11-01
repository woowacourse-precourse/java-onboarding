package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static onboarding.Problem1.Problem1Validation.validate;
import static onboarding.Util.convertIntegerToList;

class Problem1 {
    private static final int POBI = 1;
    private static final int CRONG = 2;
    private static final int DRAW = 0;
    private static final int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!validateInput(pobi, crong)) {
            return EXCEPTION;
        }
        int finalPobiScore = calculateFinalScore(pobi);
        int finalCrongScore = calculateFinalScore(crong);

        return calculateAnswer(finalPobiScore, finalCrongScore);
    }

    private static boolean validateInput(List<Integer> pobi, List<Integer> crong) {
        return validate(pobi) && validate(crong);
    }

    private static int calculateFinalScore(List<Integer> pageNumberList) {
        List<Integer> scoreList = new ArrayList<>();

        for (Integer integer : pageNumberList) {
            scoreList.add(calculateSumOfPageNumber(integer));
            scoreList.add(calculateProductOfPageNumber(integer));
        }
        return calculateMaxOfScoreList(scoreList);
    }

    private static int calculateSumOfPageNumber(int pageNumber) {
        int result = 0;

        for (Integer integer : convertIntegerToList(pageNumber)) {
            result += integer;
        }
        return result;
    }

    private static int calculateProductOfPageNumber(int pageNumber) {
        int result = 1;

        for (Integer integer : convertIntegerToList(pageNumber)) {
            result *= integer;
        }
        return result;
    }

    private static int calculateMaxOfScoreList(List<Integer> candidateScoreList) {
        return Collections.max(candidateScoreList);
    }

    private static int calculateAnswer(int pobi, int crong) {
        if (pobi > crong) {
            return POBI;
        } else if (pobi < crong) {
            return CRONG;
        }
        return DRAW;
    }


    static abstract class Problem1Validation extends Validation {
        private static final int pageSize = 2;
        private static final int START_PAGE_NUMBER = 1;
        private static final int END_PAGE_NUMBER = 400;

        public static boolean validate(List<Integer> pageNumberList) {
            return validateNotNull(pageNumberList)
                    && validateListSize(pageNumberList, pageSize)
                    && validateRange(pageNumberList)
                    && validateOrder(pageNumberList);
        }

        private static boolean validateRange(List<Integer> pageNumberList) {
            return pageNumberList.get(0) >= START_PAGE_NUMBER
                    && pageNumberList.get(1) <= END_PAGE_NUMBER;
        }

        private static boolean validateOrder(List<Integer> pageNumberList) {
            return pageNumberList.get(1) - pageNumberList.get(0) == 1;
        }
    }
}