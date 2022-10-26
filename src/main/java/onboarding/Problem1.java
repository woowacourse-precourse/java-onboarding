package onboarding;

import problem1.GameResultStatus;
import problem1.Referee;

import java.util.List;

class Problem1 {

    public static final int EXCEPTION_GAME_RESULT = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            Referee referee = new Referee(pobi, crong);
            GameResultStatus gameResult = referee.playGame();

            return gameResult.getResult();
        } catch (IllegalArgumentException e) {
            return EXCEPTION_GAME_RESULT;
        }
    }
}