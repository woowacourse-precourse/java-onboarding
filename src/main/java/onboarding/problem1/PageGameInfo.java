package onboarding.problem1;

import static onboarding.problem1.consts.ExceptionErrorMessageConst.*;
import static onboarding.problem1.consts.GameResultConst.PLAYER_A_WIN_RESULT;
import static onboarding.problem1.consts.GameResultConst.PLAYER_B_WIN_RESULT;
import static onboarding.problem1.consts.GameResultConst.TIE_RESULT;
import static onboarding.problem1.consts.PageIndexConst.LIST_LEFT_PAGE_INDEX;
import static onboarding.problem1.consts.PageIndexConst.LIST_RIGHT_PAGE_INDEX;
import static onboarding.problem1.consts.PageValidateConst.ADD_ODD_DIVISION_VALUE;
import static onboarding.problem1.consts.PageValidateConst.ADD_ODD_REMAINDER_VALUE;
import static onboarding.problem1.consts.PageValidateConst.BETWEEN_LEFT_AND_RIGHT_PAGE;
import static onboarding.problem1.consts.PageValidateConst.MAXIMUM_PAGE;
import static onboarding.problem1.consts.PageValidateConst.MINIMUM_PAGE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PageGameInfo {

    private final Map<String, Player> players;

    public PageGameInfo() {
        this.players = new HashMap<>();
    }

    public void registryPlayer(String playerName, List<Integer> playerPage) {
        Integer leftPageNumber = playerPage.get(LIST_LEFT_PAGE_INDEX);
        Integer rightPageNumber = playerPage.get(LIST_RIGHT_PAGE_INDEX);

        validatePageValue(playerPage);
        validatePageRange(leftPageNumber);
        validatePageRange(rightPageNumber);
        validateBetweenLeftAndRightPage(leftPageNumber, rightPageNumber);
        validateRightPage(rightPageNumber);
        validateLeftPage(leftPageNumber);
        players.put(playerName, new Player(leftPageNumber, rightPageNumber));
    }

    public int playGameResult(String playerA, String playerB) {
        int playerAScore = players.get(playerA).getPlayerScore();
        int playerBScore = players.get(playerB).getPlayerScore();

        if (playerAScore == playerBScore) {
            return TIE_RESULT;
        }
        return playerAScore > playerBScore ? PLAYER_A_WIN_RESULT : PLAYER_B_WIN_RESULT;
    }

    private void validatePageValue(List<Integer> playerPage) {
        if (playerPage.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException(INVALID_PAGE_VALUE_MESSAGE);
        }
    }

    private void validatePageRange(Integer pageNumber) {
        if (!(MINIMUM_PAGE <= pageNumber && pageNumber <= MAXIMUM_PAGE)) {
            throw new IllegalArgumentException(INVALID_PAGE_RANGE_MESSAGE);
        }
    }

    private void validateBetweenLeftAndRightPage(Integer leftPageNumber, Integer rightPageNumber) {
        if (rightPageNumber - leftPageNumber != BETWEEN_LEFT_AND_RIGHT_PAGE) {
            throw new IllegalArgumentException(INVALID_PAGE_RELATION_MESSAGE);
        }
    }

    private void validateRightPage(Integer rightPageNumber) {
        if (rightPageNumber % ADD_ODD_DIVISION_VALUE != ADD_ODD_REMAINDER_VALUE) {
            throw new IllegalArgumentException(RIGHT_PAGE_NOT_EVEN_MESSAGE);
        }
    }

    private void validateLeftPage(Integer leftPageNumber) {
        if (leftPageNumber % ADD_ODD_DIVISION_VALUE == ADD_ODD_REMAINDER_VALUE) {
            throw new IllegalArgumentException(LEFT_PAGE_NOT_ODD_MESSAGE);
        }
    }
}
