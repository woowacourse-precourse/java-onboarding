package onboarding;

import java.util.List;

import onboarding.pageGame.PageGame;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		PageGame playing = new PageGame(pobi, crong);
		return playing.findWinner();
	}
}
