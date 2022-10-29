package onboarding.problem1;

import static onboarding.common.consts.DigitNumberCommonConst.CALCULATE_REMAINDER_VALUE;
import static onboarding.common.consts.DigitNumberCommonConst.DECIMAL_UNIT_VALUE;
import static onboarding.problem1.consts.CalculateGameScoreConst.ADD_SCORE_DEFAULT_VALUE;
import static onboarding.problem1.consts.CalculateGameScoreConst.MULTIPLY_SCORE_DEFAULT_VALUE;

public class Player {

    private final int leftPageNumber;
    private final int rightPageNumber;
    private final int playerScore;

    public Player(int leftPageNumber, int rightPageNumber) {
        this.leftPageNumber = leftPageNumber;
        this.rightPageNumber = rightPageNumber;
        playerScore = initPlayerScore();
    }

    private int initPlayerScore() {
        return Math.max(calculatePageScore(leftPageNumber), calculatePageScore(rightPageNumber));
    }

    private int calculatePageScore(int pageNumber) {
        return Math.max(calculateAddPageScore(pageNumber), calculateMultiplyPageScore(pageNumber));
    }

    private int calculateAddPageScore(int pageNumber) {
        int addScore = ADD_SCORE_DEFAULT_VALUE;

        while (pageNumber != CALCULATE_REMAINDER_VALUE) {
            addScore += pageNumber % DECIMAL_UNIT_VALUE;
            pageNumber /= DECIMAL_UNIT_VALUE;
        }
        return addScore;
    }

    private int calculateMultiplyPageScore(int pageNumber) {
        int multiplyScore = MULTIPLY_SCORE_DEFAULT_VALUE;

        while (pageNumber != CALCULATE_REMAINDER_VALUE) {
            multiplyScore *= pageNumber % DECIMAL_UNIT_VALUE;
            pageNumber /= DECIMAL_UNIT_VALUE;
        }
        return multiplyScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }
}
