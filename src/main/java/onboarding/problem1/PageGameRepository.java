package onboarding.problem1;

import static onboarding.problem1.consts.ExceptionErrorMessageConst.*;
import static onboarding.problem1.consts.GameResultConst.PLAYER_A_WIN_RESULT_VALUE;
import static onboarding.problem1.consts.GameResultConst.PLAYER_B_WIN_RESULT_VALUE;
import static onboarding.problem1.consts.GameResultConst.TIE_RESULT_VALUE;
import static onboarding.problem1.consts.PageIndexConst.LIST_LEFT_PAGE_INDEX_VALUE;
import static onboarding.problem1.consts.PageIndexConst.LIST_RIGHT_PAGE_INDEX_VALUE;
import static onboarding.problem1.consts.PageValidateConst.ADD_ODD_DIVISION_VALUE;
import static onboarding.problem1.consts.PageValidateConst.ADD_ODD_REMAINDER_VALUE;
import static onboarding.problem1.consts.PageValidateConst.BETWEEN_LEFT_AND_RIGHT_PAGE_VALUE;
import static onboarding.problem1.consts.PageValidateConst.MAXIMUM_PAGE_VALUE;
import static onboarding.problem1.consts.PageValidateConst.MINIMUM_PAGE_VALUE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 페이지 게임에 참여하는 플레이어의 정보를 관리하는 일급 컬렉션
 */
public class PageGameRepository {

    /**
     * (플레이어 ID, Player) 방식으로 플레이어의 정보를 관리하는 컬렉션
     */
    private final Map<String, Player> players;

    /**
     * 내부 컬렉션을 초기화하는 기본 생성자
     */
    public PageGameRepository() {
        this.players = new HashMap<>();
    }

    /**
     * 플레이어를 등록하는 메소드
     *
     * @param playerName 플레이어 이름
     * @param playerPage List타입의 플레이어 페이지
     * @throws IllegalArgumentException 올바른 페이지가 아닌 경우
     */
    public void registryPlayer(String playerName, List<Integer> playerPage) {
        int leftPageNumber = playerPage.get(LIST_LEFT_PAGE_INDEX_VALUE);
        int rightPageNumber = playerPage.get(LIST_RIGHT_PAGE_INDEX_VALUE);

        validatePageValue(playerPage);
        validatePageRange(leftPageNumber);
        validatePageRange(rightPageNumber);
        validateBetweenLeftAndRightPage(leftPageNumber, rightPageNumber);
        validateRightPage(rightPageNumber);
        validateLeftPage(leftPageNumber);
        players.put(playerName, new Player(leftPageNumber, rightPageNumber));
    }

    /**
     * 페이지 게임을 진행해 결과를 반환하는 메소드
     *
     * @param playerA 플레이어 A(포비)
     * @param playerB 플레이어 B(크롱)
     * @return 무승부일 경우 0, 포비가 이겼을 경우 1, 크롱이 이겼을 경우 2
     */
    public int play(String playerA, String playerB) {
        int playerAScore = players.get(playerA).getPlayerScore();
        int playerBScore = players.get(playerB).getPlayerScore();

        if (playerAScore == playerBScore) {
            return TIE_RESULT_VALUE;
        }
        return playerAScore > playerBScore ? PLAYER_A_WIN_RESULT_VALUE : PLAYER_B_WIN_RESULT_VALUE;
    }

    /**
     * 페이지의 값이 모두 유효한지 검증하는 메소드
     *
     * @param playerPage 플레이어의 모든 페이지
     * @throws IllegalArgumentException 페이지에 null이 있는 경우
     */
    private void validatePageValue(List<Integer> playerPage) {
        if (playerPage.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException(INVALID_PAGE_VALUE_MESSAGE);
        }
    }

    /**
     * 페이지의 값이 유효한 범위인지 검증하는 메소드
     *
     * @param pageNumber 검증할 페이지
     * @throws IllegalArgumentException 페이지의 범위가 3 ~ 398 사이가 아닌 경우
     */
    private void validatePageRange(int pageNumber) {
        if (!(MINIMUM_PAGE_VALUE <= pageNumber && pageNumber <= MAXIMUM_PAGE_VALUE)) {
            throw new IllegalArgumentException(INVALID_PAGE_RANGE_MESSAGE);
        }
    }

    /**
     * 두 페이지가 연속된 페이지인지 검증하는 메소드
     *
     * @param leftPageNumber  왼쪽 페이지
     * @param rightPageNumber 오른쪽 페이지
     * @throws IllegalArgumentException 두 페이지의 차가 1이 아닌 경우
     */
    private void validateBetweenLeftAndRightPage(int leftPageNumber, int rightPageNumber) {
        if (rightPageNumber - leftPageNumber != BETWEEN_LEFT_AND_RIGHT_PAGE_VALUE) {
            throw new IllegalArgumentException(INVALID_PAGE_RELATION_MESSAGE);
        }
    }

    /**
     * 오른쪽 페이지가 짝수인지 검증하는 메소드
     *
     * @param rightPageNumber 오른쪽 페이지
     * @throws IllegalArgumentException 오른쪽 페이지가 짝수가 아닌 경우
     */
    private void validateRightPage(int rightPageNumber) {
        if (rightPageNumber % ADD_ODD_DIVISION_VALUE != ADD_ODD_REMAINDER_VALUE) {
            throw new IllegalArgumentException(RIGHT_PAGE_NOT_EVEN_MESSAGE);
        }
    }

    /**
     * 왼쪽 페이지가 홀수인지 검증하는 메소드
     *
     * @param leftPageNumber 왼쪽 페이지
     * @throws IllegalArgumentException 왼쪽 페이지가 홀수가 아닌 경우
     */
    private void validateLeftPage(int leftPageNumber) {
        if (leftPageNumber % ADD_ODD_DIVISION_VALUE == ADD_ODD_REMAINDER_VALUE) {
            throw new IllegalArgumentException(LEFT_PAGE_NOT_ODD_MESSAGE);
        }
    }
}
