package onboarding.problem1;

import static onboarding.common.consts.CommonDigitNumberConst.CALCULATE_REMAINDER_VALUE;
import static onboarding.common.consts.CommonDigitNumberConst.DECIMAL_UNIT_VALUE;
import static onboarding.problem1.consts.CalculateGameScoreConst.ADD_SCORE_DEFAULT_VALUE;
import static onboarding.problem1.consts.CalculateGameScoreConst.MULTIPLY_SCORE_DEFAULT_VALUE;

/**
 * 페이지 게임에 참여하는 플레이어의 정보를 정의한 클래스
 */
public class Player {

    /**
     * 플레이어의 왼쪽 페이지
     */
    private final int leftPageNumber;

    /**
     * 플레이어의 오른쪽 페이지
     */
    private final int rightPageNumber;

    /**
     * 플레이어의 점수
     */
    private final int playerScore;

    /**
     * 플레이어의 페이지 정보, 점수를 초기화하는 생성자
     *
     * @param leftPageNumber  플레이어의 검증된 왼쪽 페이지
     * @param rightPageNumber 플레이어의 검증된 오른쪽 페이지
     */
    public Player(int leftPageNumber, int rightPageNumber) {
        this.leftPageNumber = leftPageNumber;
        this.rightPageNumber = rightPageNumber;
        playerScore = initPlayerScore();
    }

    /**
     * 플레이어 점수를 계산하는 메소드
     *
     * @return 모든 페이지 자릿수를 모두 곱한 값과 더한 값 중 가장 큰 값
     */
    private int initPlayerScore() {
        return Math.max(calculatePageScore(leftPageNumber), calculatePageScore(rightPageNumber));
    }

    /**
     * 주어진 페이지의 점수를 계산하는 메소드
     *
     * @param pageNumber 점수를 계산할 페이지
     * @return 주어진 페이지의 자릿수를 모두 곱한 값과 더한 값 중 가장 큰 값
     */
    private int calculatePageScore(int pageNumber) {
        return Math.max(calculateAddPageScore(pageNumber), calculateMultiplyPageScore(pageNumber));
    }

    /**
     * 주어진 페이지의 자릿수를 모두 더하는 메소드
     *
     * @param pageNumber 계산할 페이지
     * @return 주어진 페이지의 자릿수를 모두 더한 값
     */
    private int calculateAddPageScore(int pageNumber) {
        int addScore = ADD_SCORE_DEFAULT_VALUE;

        while (pageNumber != CALCULATE_REMAINDER_VALUE) {
            addScore += pageNumber % DECIMAL_UNIT_VALUE;
            pageNumber /= DECIMAL_UNIT_VALUE;
        }
        return addScore;
    }

    /**
     * 주어진 페이지의 자릿수를 모두 곱하는 메소드
     *
     * @param pageNumber 계산할 페이지
     * @return 주어진 페이지의 자릿수를 모두 곱한 값
     */
    private int calculateMultiplyPageScore(int pageNumber) {
        int multiplyScore = MULTIPLY_SCORE_DEFAULT_VALUE;

        while (pageNumber != CALCULATE_REMAINDER_VALUE) {
            multiplyScore *= pageNumber % DECIMAL_UNIT_VALUE;
            pageNumber /= DECIMAL_UNIT_VALUE;
        }
        return multiplyScore;
    }

    /**
     * 플레이어의 점수를 반환하는 메소드
     *
     * @return 플레이어의 점수
     */
    public int getPlayerScore() {
        return playerScore;
    }
}
