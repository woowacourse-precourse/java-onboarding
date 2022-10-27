package onboarding.problem1;

import static onboarding.problem1.ResultType.*;

import java.util.Arrays;
import java.util.List;

public class GameController {
	private final List<Integer> pobi;
	private final List<Integer> crong;
	private static final int lastPage = 400;

	public GameController(List<Integer> pobi, List<Integer> crong) {
		this.pobi = pobi;
		this.crong = crong;
	}

	public int playGame() {
		PageValidChecker pageValidChecker = new PageValidChecker(lastPage);
		List<List<Integer>> users = Arrays.asList(pobi, crong);
		if (!users.stream().allMatch(pageValidChecker::checkValid)) {
			return ERROR.getCode();
		}

		ScoreCalculator scoreCalculator = new ScoreCalculator();
		int pobiScore = scoreCalculator.getScore(pobi);
		int crongScore = scoreCalculator.getScore(crong);

		WinnerSelector winnerSelector = new WinnerSelector();
		ResultType winner = winnerSelector.getWinner(pobiScore, crongScore);

		return winner.getCode();
	}
}
