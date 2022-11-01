package onboarding.problem1;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {

    private final ScoreCalculator scoreCalculator;
    private final PageValidator pageValidator;
    private final List<GamePlayer> gamePlayerList = new ArrayList<>();
    private int gameResult;

    public GameBoard(ScoreCalculator scoreCalculator, PageValidator pageValidator) {
        this.scoreCalculator = scoreCalculator;
        this.pageValidator = pageValidator;
    }

    public void playtheGame(List<Integer> page1, List<Integer> page2) {
        try {
            createGamePlayerList(page1, page2);
            calculateScore();
        } catch (IllegalArgumentException e) {
            this.gameResult = ILLEGAL_PAGE.gameResult();
        }
    }

    private void createGamePlayerList(List<Integer> page1, List<Integer> page2) {
        gamePlayerList.add(pageValidator.getPlayer(page1));
        gamePlayerList.add(pageValidator.getPlayer(page2));
    }

    private void calculateScore() {
        final int FIRST_PLAYER = 0;
        final int LAST_PLAYER = 1;
        int gamePlayer1Score = scoreCalculator.getGameScore(gamePlayerList.get(FIRST_PLAYER));
        int gamePlayer2Score = scoreCalculator.getGameScore(gamePlayerList.get(LAST_PLAYER));
        getWinner(gamePlayer1Score, gamePlayer2Score);
    }
}
