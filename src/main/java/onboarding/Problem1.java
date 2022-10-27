package onboarding;

import java.util.List;

import onboarding.problem1.GameController;
import onboarding.problem1.PageValidCheckerImp;
import onboarding.problem1.ScoreCalculatorImp;
import onboarding.problem1.WinnerSelectorImp;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int lastPage = 400;
		GameController gameController = new GameController(new PageValidCheckerImp(lastPage), new ScoreCalculatorImp(),
			new WinnerSelectorImp());
		int answer = gameController.playGame(pobi, crong);
		return answer;
	}
}