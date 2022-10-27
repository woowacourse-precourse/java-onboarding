package onboarding;

import java.util.List;

import onboarding.problem1.GameController;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		GameController gameController = new GameController(pobi, crong);
		int answer = gameController.playGame();
		return answer;
	}
}