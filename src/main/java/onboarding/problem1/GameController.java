package onboarding.problem1;

import static onboarding.problem1.ResultType.*;

import java.util.Arrays;
import java.util.List;

public class GameController {
	private PageValidChecker pageValidChecker;
	private ScoreCalculator scoreCalculator;
	private WinnerSelector winnerSelector;

	public GameController(PageValidChecker pageValidChecker, ScoreCalculator scoreCalculator,
		WinnerSelector winnerSelector) {
		this.pageValidChecker = pageValidChecker;
		this.scoreCalculator = scoreCalculator;
		this.winnerSelector = winnerSelector;
	}

	public int playGame(List<Integer> pobi, List<Integer> crong) {
		List<List<Integer>> users = Arrays.asList(pobi, crong);
		if (!users.stream().allMatch(pageValidChecker::checkValid)) {
			return ERROR.getCode();
		}

		int pobiScore = scoreCalculator.getScore(pobi);
		int crongScore = scoreCalculator.getScore(crong);

		ResultType winner = winnerSelector.getWinner(pobiScore, crongScore);

		return winner.getCode();
	}
}
