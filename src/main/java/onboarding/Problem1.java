package onboarding;

import static onboarding.Problem1.CalculateScoreConst.ADD_SCORE_DEFAULT_VALUE;
import static onboarding.Problem1.CalculateScoreConst.CALCULATE_REMAINDER_VALUE;
import static onboarding.Problem1.CalculateScoreConst.DECIMAL_UNIT_VALUE;
import static onboarding.Problem1.CalculateScoreConst.MULTIPLY_SCORE_DEFAULT_VALUE;
import static onboarding.Problem1.GameCalculator.calculateGameResult;
import static onboarding.Problem1.GameResultConst.CRONG_WIN_RESULT;
import static onboarding.Problem1.GameResultConst.EXCEPTION_RESULT;
import static onboarding.Problem1.GameResultConst.POBI_WIN_RESULT;
import static onboarding.Problem1.GameResultConst.TIE_RESULT;
import static onboarding.Problem1.PageIndexConst.LEFT_PAGE_LIST_INDEX;
import static onboarding.Problem1.PageIndexConst.RIGHT_PAGE_LIST_INDEX;
import static onboarding.Problem1.PageValidateConst.ADD_ODD_DIVISION_VALUE;
import static onboarding.Problem1.PageValidateConst.ADD_ODD_REMAINDER_VALUE;
import static onboarding.Problem1.PageValidateConst.BETWEEN_LEFT_AND_RIGHT_PAGE;
import static onboarding.Problem1.PageValidateConst.MAXIMUM_PAGE;
import static onboarding.Problem1.PageValidateConst.MINIMUM_PAGE;
import static onboarding.Problem1.PageValidator.validatePage;

import java.util.List;
import java.util.Objects;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        return calculateGameResult(pobi, crong);
    }

    public static class PageValidator {

        private PageValidator() {
        }

        public static boolean validatePage(List<Integer> player) {
            Integer leftPageNumber = player.get(LEFT_PAGE_LIST_INDEX);
            Integer rightPageNumber = player.get(RIGHT_PAGE_LIST_INDEX);

            return validatePageRange(leftPageNumber) && validatePageRange(rightPageNumber)
                && validateRightPage(rightPageNumber) && validateLeftPage(leftPageNumber)
                && validatePageValue(player) && validateBetweenLeftAndRightPage(leftPageNumber,
                rightPageNumber);
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

        private static boolean validatePageValue(List<Integer> player) {
            return !player.stream().anyMatch(Objects::isNull);
        }
    }

    public static class GameCalculator {

        private GameCalculator() {
        }

        public static int calculateGameResult(List<Integer> pobi, List<Integer> crong) {
            if (!(validatePage(pobi) && validatePage(crong))) {
                return EXCEPTION_RESULT;
            }

            int pobiScore = calculatePlayerScore(pobi);
            int crongScore = calculatePlayerScore(crong);

            return pobiScore > crongScore ? POBI_WIN_RESULT
                : pobiScore < crongScore ? CRONG_WIN_RESULT : TIE_RESULT;
        }

        private static int calculatePageScore(Integer pageNumber) {
            return Math.max(calculateAddPageScore(pageNumber),
                calculateMultiplyPageScore(pageNumber));
        }

        private static int calculateAddPageScore(Integer pageNumber) {
            int targetPageNumber = pageNumber;
            int addScore = ADD_SCORE_DEFAULT_VALUE;

            while (targetPageNumber != CALCULATE_REMAINDER_VALUE) {
                addScore += targetPageNumber % DECIMAL_UNIT_VALUE;
                targetPageNumber /= DECIMAL_UNIT_VALUE;
            }
            return addScore;
        }

        private static int calculateMultiplyPageScore(Integer pageNumber) {
            int targetPageNumber = pageNumber;
            int multiplyScore = MULTIPLY_SCORE_DEFAULT_VALUE;

            while (targetPageNumber != CALCULATE_REMAINDER_VALUE) {
                multiplyScore *= targetPageNumber % DECIMAL_UNIT_VALUE;
                targetPageNumber /= DECIMAL_UNIT_VALUE;
            }
            return multiplyScore;
        }

        private static int calculatePlayerScore(List<Integer> player) {
            int leftPageScore = calculatePageScore(player.get(LEFT_PAGE_LIST_INDEX));
            int rightPageScore = calculatePageScore(player.get(RIGHT_PAGE_LIST_INDEX));

            return Math.max(leftPageScore, rightPageScore);
        }
    }

    public abstract class GameResultConst {

        public static final int EXCEPTION_RESULT = -1;
        public static final int TIE_RESULT = 0;
        public static final int POBI_WIN_RESULT = 1;
        public static final int CRONG_WIN_RESULT = 2;
    }

    public abstract class PageIndexConst {

        public static final int LEFT_PAGE_LIST_INDEX = 0;
        public static final int RIGHT_PAGE_LIST_INDEX = 1;
    }

    public abstract class PageValidateConst {

        public static final int MINIMUM_PAGE = 3;
        public static final int MAXIMUM_PAGE = 398;
        public static final int BETWEEN_LEFT_AND_RIGHT_PAGE = 1;
        public static final int ADD_ODD_REMAINDER_VALUE = 0;
        public static final int ADD_ODD_DIVISION_VALUE = 2;
    }

    public abstract class CalculateScoreConst {

        public static final int ADD_SCORE_DEFAULT_VALUE = 0;
        public static final int MULTIPLY_SCORE_DEFAULT_VALUE = 1;
        public static final int CALCULATE_REMAINDER_VALUE = 0;
        public static final int DECIMAL_UNIT_VALUE = 10;
    }
}