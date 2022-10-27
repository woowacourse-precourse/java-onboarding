package onboarding.problem1;

import java.util.Arrays;
import java.util.List;

public class GameController {
	private final List<Integer> pobi;
	private final List<Integer> crong;
	private static final int lastPage = 400;
	private PageValidChecker pageValidChecker;
	private ScoreCalculator scoreCalculator;
	private WinnerSelector winnerSelector;

	public GameController(List<Integer> pobi, List<Integer> crong) {
		this.pobi = pobi;
		this.crong = crong;
	}

	public int playGame() {
		pageValidChecker = new PageValidChecker(lastPage);
		List<List<Integer>> users = Arrays.asList(pobi, crong);
		if (!users.stream().allMatch(u -> pageValidChecker.checkValid(u))) {
			return -1;
		}

		scoreCalculator = new ScoreCalculator();
		int pobiScore = scoreCalculator.getScore(pobi);
		int crongScore = scoreCalculator.getScore(crong);

		winnerSelector = new WinnerSelector();
		int result = winnerSelector.getWinner(pobiScore, crongScore);

		return result;
	}
}
