package onboarding.problem1;

import static onboarding.problem1.PageValidator.validatePage;
import static onboarding.problem1.consts.CalculateGameScoreConst.ADD_SCORE_DEFAULT_VALUE;
import static onboarding.problem1.consts.CalculateGameScoreConst.CALCULATE_REMAINDER_VALUE;
import static onboarding.problem1.consts.CalculateGameScoreConst.DECIMAL_UNIT_VALUE;
import static onboarding.problem1.consts.CalculateGameScoreConst.MULTIPLY_SCORE_DEFAULT_VALUE;
import static onboarding.problem1.consts.GameResultConst.CRONG_WIN_RESULT;
import static onboarding.problem1.consts.GameResultConst.EXCEPTION_RESULT;
import static onboarding.problem1.consts.GameResultConst.POBI_WIN_RESULT;
import static onboarding.problem1.consts.GameResultConst.TIE_RESULT;
import static onboarding.problem1.consts.PageIndexConst.LIST_LEFT_PAGE_INDEX;
import static onboarding.problem1.consts.PageIndexConst.LIST_RIGHT_PAGE_INDEX;

import java.util.List;

public class GameCalculator {

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
        int leftPageScore = calculatePageScore(player.get(LIST_LEFT_PAGE_INDEX));
        int rightPageScore = calculatePageScore(player.get(LIST_RIGHT_PAGE_INDEX));

        return Math.max(leftPageScore, rightPageScore);
    }
}
