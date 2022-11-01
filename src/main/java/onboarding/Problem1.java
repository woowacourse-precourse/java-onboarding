package onboarding;

import onboarding.problem1.GameBoard;
import onboarding.problem1.PageValidator;
import onboarding.problem1.ScoreCalculator;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        GameBoard gameBoard = new GameBoard(new ScoreCalculator(), new PageValidator());
        gameBoard.playtheGame(pobi, crong);
        return gameBoard.getResult();
    }
}