package onboarding;

import onboarding.problem1.GameResult;
import onboarding.problem1.PageNumberGame;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        PageNumberGame openBookGame = new PageNumberGame();
        GameResult gameResult = openBookGame.play(pobi, crong);

        return gameResult.getCode();
    }
}
