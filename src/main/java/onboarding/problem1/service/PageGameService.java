package onboarding.problem1.service;

import onboarding.problem1.vo.Score;

import java.util.List;

/**
 * 페이지 번호 게임과 관련된 비즈니스 로직을 진행하는 서비스 레이어 클래스입니다.
 * @author BackFoxx
 */
public class PageGameService {
    public static final int EXCEPTION_RETURN_VALUE = -1;
    public static final int PLAYER1_WINNER_RETURN_VALUE = 1;
    public static final int PLAYER2_WINNER_RETURN_VALUE = 2;
    public static final int TIE = 0;

    /**
     * 두 플레이어가 임의로 펼친 두 페이지의 숫자로 페이지 번호 게임을 실행해
     * 게임 결과를 Integer 값으로 반환하는 메소드입니다.
     * @param player1 player1이 펼친 왼쪽 페이지와 오른쪽 페이지 값이 담긴 Integer 리스트입니다.
     * @param player2 player2가 펼친 왼쪽 페이지와 오른쪽 페이지 값이 담긴 Integer 리스트입니다.
     * @return 게임 결과에 해당하는 상수 Integer 값입니다.
     */
    public static Integer playGame(List<Integer> player1, List<Integer> player2) {
        try {
            Score player1Score = ScoreService.getHighestScore(player1);
            Score player2Score = ScoreService.getHighestScore(player2);

            if (player1Score.isHigherThan(player2Score)) {
                return PLAYER1_WINNER_RETURN_VALUE;
            } else if (player1Score.isLowerThan(player2Score)) {
                return PLAYER2_WINNER_RETURN_VALUE;
            }

            return TIE;
        } catch (IllegalArgumentException exception) {
            return EXCEPTION_RETURN_VALUE;
        }
    }
}
