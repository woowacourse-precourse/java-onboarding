package onboarding;

import onboarding.problem1.*;

import java.util.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        GameBoard gameBoard = new GameBoard(new ScoreCalculator(), new PageValidator());
        gameBoard.playtheGame(pobi, crong);
        return gameBoard.getResult();
    }
}