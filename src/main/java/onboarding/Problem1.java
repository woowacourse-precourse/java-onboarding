package onboarding;

import onboarding.problem1.Game;
import onboarding.problem1.Result;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Game game = new Game();
        Result result = game.play(pobi, crong);

        return result.getValue();
    }
}