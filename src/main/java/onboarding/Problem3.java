package onboarding;

import onboarding.problem3.Match369RangeGame;

public class Problem3 {

    public static int solution(int number) {
        Match369RangeGame game = new Match369RangeGame();

        return game.getMatchRangeCount(1, number);
    }
}
