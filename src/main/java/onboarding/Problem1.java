package onboarding;

import java.util.List;

import onboarding.pagenumbergame.PageNumberGame;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        PageNumberGame pageNumberGame
            = new PageNumberGame(pobi, crong);
        return pageNumberGame.play();
    }
}