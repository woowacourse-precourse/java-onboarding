package onboarding.problem1;

import onboarding.problem1.exception.GameRuntimeException;
import onboarding.problem1.openbookpage.OpenBookPage;
import onboarding.problem1.openbookpage.OpenBookPageMapper;
import onboarding.problem1.openbookpage.OpenBookPageService;

import java.util.List;

public class PageNumberGame {

    OpenBookPageMapper openBookPageMapper = new OpenBookPageMapper();
    OpenBookPageService openBookPageService = new OpenBookPageService();

    public GameResult play(List<Integer> player1, List<Integer> player2) {
        try {
            int player1Point = getPlayerPoint(player1);
            int player2Point = getPlayerPoint(player2);

            return getGameResult(player1Point, player2Point);
        } catch (GameRuntimeException e) {
            return GameResult.EXCEPTION;
        }
    }

    private int getPlayerPoint(List<Integer> player) {
        OpenBookPage playerBookPage = openBookPageMapper.map(player);

        return openBookPageService.getLargeBookPoint(playerBookPage);
    }

    private GameResult getGameResult(int player1Point, int player2Point) {
        if (checkDraw(player1Point, player2Point)) {
            return GameResult.DRAW;
        }
        return comparePlayer(player1Point, player2Point);
    }

    private boolean checkDraw(int player1Point, int player2Point) {
        return player1Point == player2Point;
    }

    private GameResult comparePlayer(int player1Point, int player2Point) {
        if (player1Point > player2Point) {
            return GameResult.PLAYER1_WIN;
        }

        return GameResult.PLAYER2_WIN;
    }
}
