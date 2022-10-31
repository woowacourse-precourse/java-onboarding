package onboarding;

import onboarding.problem1.Game;
import onboarding.problem1.Result;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        validatePobiCrongRange(pobi, crong);

        Game game = new Game();
        Result result = game.play(pobi, crong);

        return result.getValue();
    }

    private static void validatePobiCrongRange(List<Integer> pobi, List<Integer> crong) throws IllegalArgumentException {
        if (pobi.size() != 2) {
            throw new IllegalArgumentException("pobi의 길이는 2여야 합니다.");
        }

        if (crong.size() != 2) {
            throw new IllegalArgumentException("crong의 길이는 2여야 합니다.");
        }
    }
}