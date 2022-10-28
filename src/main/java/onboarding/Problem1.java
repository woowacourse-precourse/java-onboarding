package onboarding;

import static onboarding.problem1.Problem1Constant.*;

import java.util.ArrayList;
import java.util.List;

import onboarding.problem1.application.PlayerService;
import onboarding.problem1.application.ScoreService;
import onboarding.problem1.application.Validation;
import onboarding.problem1.config.BookGameDependencyConfigurer;
import onboarding.problem1.exception.BookGameException;

class Problem1 {

	private static final BookGameDependencyConfigurer bookGameConfig = new BookGameDependencyConfigurer();

	public static int solution(List<Integer> pobi, List<Integer> crong) {
		PlayerService playerService = bookGameConfig.playerService();
		ScoreService scoreService = bookGameConfig.scoreService();
		Validation validation = bookGameConfig.validation();

		try {
			validation.isValid(pobi);
			validation.isValid(crong);
		} catch (BookGameException bookGameException) {
			return bookGameException.getExceptionCode();
		}

		return answer;
	}

	public static int getScore(List<Integer> pages) {
		Integer leftPage = pages.get(LEFT_PAGE_INDEX);
		Integer rightPage = pages.get(RIGHT_PAGE_INDEX);

		int maxNumberOfLeftPage = getMaxNumberByPage(leftPage);
		int maxNumberOfRightPage = getMaxNumberByPage(rightPage);

		if (maxNumberOfLeftPage > maxNumberOfRightPage) {
			return maxNumberOfLeftPage;
		}

		return maxNumberOfRightPage;
	}

	public static int getResultCode(final int pobiScore, final int crongScore) {
		int resultCode = 0;
		if (pobiScore > crongScore) {
			resultCode = POBI_WIN_CODE;
		} else if (pobiScore < crongScore) {
			resultCode = CRONG_WIN_CODE;
		} else {
			resultCode =  DRAW_CODE;
		}

		return resultCode;
	}

	private static int getMaxNumberByPage(int page) {
		List<Integer> pageEach = separateInteger(page);

		int sum = getSum(pageEach);
		int multiples = getMultiples(pageEach);

		if (sum > multiples) {
			return sum;
		}

		return multiples;
	}

	private static List<Integer> separateInteger(int target) {
		List<Integer> separated = new ArrayList<>();

		while (target != 0) {
			int singleNumber = target % 10;
			separated.add(singleNumber);

			target /= 10;
		}

		return separated;
	}

	private static int getSum(List<Integer> integers) {
		return integers.stream()
			.mapToInt(i -> i)
			.sum();
	}

	private static int getMultiples(List<Integer> integers) {
		int result = 1;
		for (Integer integer : integers) {
			result *= integer;
		}

		return result;
	}

}