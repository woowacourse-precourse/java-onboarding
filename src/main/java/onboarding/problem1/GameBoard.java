package onboarding.problem1;

import java.util.ArrayList;

public class GameBoard {

    private final ScoreCalculator scoreCalculator;
    private final PageValidator pageValidator;
    private final List<GamePlayer> gamePlayerList = new ArrayList<>();
    private int gameResult;

    public GameBoard(ScoreCalculator scoreCalculator, PageValidator pageValidator) {
        this.scoreCalculator = scoreCalculator;
        this.pageValidator = pageValidator;
    }
}
