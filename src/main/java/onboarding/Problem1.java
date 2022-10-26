package onboarding;

import java.util.List;

import onboarding.problemone.domain.Game;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {

		Game game = new Game(pobi, crong);

		int answer = game.play();
		return answer;
	}

}