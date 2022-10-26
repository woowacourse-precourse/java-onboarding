package onboarding;

import java.util.List;

class Problem1 {

    private static final int EXCEPTION_RESULT = -1;
    private static final int TIE_RESULT = 0;
    private static final int POBI_WIN_RESULT = 1;
    private static final int CRONG_WIN_RESULT = 2;

    private static final int MINIMUM_PAGE = 3;
    private static final int MAXIMUM_PAGE = 398;
    private static final int LEFT_PAGE_LIST_INDEX = 0;
    private static final int RIGHT_PAGE_LIST_INDEX = 1;
    private static final int BETWEEN_LEFT_AND_RIGHT_PAGE = 1;

    private static final int ADD_ODD_REMAINDER_VALUE = 0;
    private static final int ADD_ODD_DIVISION_VALUE = 2;

    private static final int ADD_SCORE_DEFAULT_VALUE = 0;
    private static final int MULTIPLY_SCORE_DEFAULT_VALUE = 1;
    private static final int CALCULATE_REMAINDER_VALUE = 0;
    private static final int DECIMAL_UNIT_VALUE = 10;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!(validatePage(pobi) && validatePage(crong))) {
            return EXCEPTION_RESULT;
        }

        int pobiScore = calculatePlayerScore(pobi);
        int crongScore = calculatePlayerScore(crong);

        return pobiScore > crongScore ? POBI_WIN_RESULT
            : pobiScore < crongScore ? CRONG_WIN_RESULT : TIE_RESULT;
    }

    private static boolean validatePage(List<Integer> player) {
        Integer leftPageNumber = player.get(LEFT_PAGE_LIST_INDEX);
        Integer rightPageNumber = player.get(RIGHT_PAGE_LIST_INDEX);

        return validatePageRange(leftPageNumber) && validatePageRange(rightPageNumber)
            && validateRightPage(rightPageNumber) && validateLeftPage(leftPageNumber)
            && validateBetweenLeftAndRightPage(leftPageNumber, rightPageNumber);
    }

    private static boolean validatePageRange(Integer pageNumber) {
        return MINIMUM_PAGE <= pageNumber && pageNumber <= MAXIMUM_PAGE;
    }

    private static boolean validateBetweenLeftAndRightPage(Integer leftPageNumber,
        Integer rightPageNumber) {
        return rightPageNumber - leftPageNumber == BETWEEN_LEFT_AND_RIGHT_PAGE;
    }

    private static boolean validateRightPage(Integer rightPageNumber) {
        return rightPageNumber % ADD_ODD_DIVISION_VALUE == ADD_ODD_REMAINDER_VALUE;
    }

    private static boolean validateLeftPage(Integer leftPageNumber) {
        return leftPageNumber % ADD_ODD_DIVISION_VALUE != ADD_ODD_REMAINDER_VALUE;
    }

    private static int calculatePageScore(Integer pageNumber) {
        int targetPageNumber = pageNumber;
        int addScore = ADD_SCORE_DEFAULT_VALUE;
        int multiplyScore = MULTIPLY_SCORE_DEFAULT_VALUE;

        while (targetPageNumber != CALCULATE_REMAINDER_VALUE) {
            addScore += targetPageNumber % DECIMAL_UNIT_VALUE;
            multiplyScore *= targetPageNumber % DECIMAL_UNIT_VALUE;
            targetPageNumber /= DECIMAL_UNIT_VALUE;
        }
        return Math.max(addScore, multiplyScore);
    }

    private static int calculatePlayerScore(List<Integer> player) {
        int leftPageScore = calculatePageScore(player.get(LEFT_PAGE_LIST_INDEX));
        int rightPageScore = calculatePageScore(player.get(RIGHT_PAGE_LIST_INDEX));

        return Math.max(leftPageScore, rightPageScore);
    }
}