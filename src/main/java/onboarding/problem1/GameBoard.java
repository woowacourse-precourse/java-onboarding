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
}
