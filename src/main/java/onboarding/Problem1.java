package onboarding;

import onboarding.problem1.Game;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        return Game.getGameResult(pobi, crong);
    }
}