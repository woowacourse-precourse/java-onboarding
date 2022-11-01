package onboarding.problem1.application.bookgame;

import java.util.ArrayList;
import java.util.List;

import onboarding.problem1.application.ScoreService;
import onboarding.problem1.model.Player;

public class BookGameScoreService implements ScoreService {
	@Override
	public int calculatePlayerScore(Player player) {
		int leftPage = player.getLeftPage();
		int rightPage = player.getRightPage();

		int maxNumberOfLeftPage = getMaxNumberByPage(leftPage);
		int maxNumberOfRightPage = getMaxNumberByPage(rightPage);

		if (maxNumberOfLeftPage > maxNumberOfRightPage) {
			return maxNumberOfLeftPage;
		}

		return maxNumberOfRightPage;
	}

	private int getMaxNumberByPage(int page) {
		List<Integer> pageEach = separateInteger(page);

		int sum = getSum(pageEach);
		int multiples = getMultiples(pageEach);

		if (sum > multiples) {
			return sum;
		}

		return multiples;
	}

	private List<Integer> separateInteger(int target) {
		List<Integer> separated = new ArrayList<>();

		while (target != 0) {
			int singleNumber = target % 10;
			separated.add(singleNumber);

			target /= 10;
		}

		return separated;
	}

	private int getSum(List<Integer> integers) {
		return integers.stream()
			.mapToInt(i -> i)
			.sum();
	}

	private int getMultiples(List<Integer> integers) {
		int result = 1;
		for (Integer integer : integers) {
			result *= integer;
		}

		return result;
	}
}
