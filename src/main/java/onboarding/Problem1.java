package onboarding;

import static onboarding.enums.problem1.InitNumber.*;
import static onboarding.enums.problem1.Output.*;
import static onboarding.enums.problem1.Page.*;

import java.util.List;

class Problem1 {

	public static int solution(List<Integer> pobi, List<Integer> crong) {
		if (isException(pobi) || isException(crong)) {
			return EXCEPTION.getResult();
		}

		return makeWinner(maxScore(pobi), maxScore(crong));
	}

	public static boolean isException(List<Integer> pageList) {
		if (isPageIntervalException(pageList) || isPagePositionException(pageList) || isPageRangeException(pageList)) {
			return true;
		}

		return false;
	}

	private static boolean isPageRangeException(List<Integer> pageList) {
		for (Integer pageNumber : pageList) {
			if (pageNumber > MAX_PAGE.getPage() || pageNumber < MIN_PAGE.getPage()) {
				return true;
			}
		}
		return false;
	}

	private static boolean isPagePositionException(List<Integer> pageList) {
		return (pageList.get(RIGHT_PAGE.getPage()) < pageList.get(LEFT_PAGE.getPage()));
	}

	private static boolean isPageIntervalException(List<Integer> pageList) {
		return (pageList.get(RIGHT_PAGE.getPage()) - pageList.get(LEFT_PAGE.getPage())
			> PAGE_INTERVAL.getPage());
	}

	public static int maxScore(List<Integer> pageList) {
		int max = INIT_ZERO.getNumber();

		for (Integer pageNumber : pageList) {
			if (max < compareSum(pageNumber)) {
				max = compareSum(pageNumber);
			}
		}
		return max;
	}

	public static int compareSum(int pageNumber) {
		String[] pageNumberSplit = String.valueOf(pageNumber).split("");

		return Math.max(maxPlusSum(pageNumberSplit), maxMultiplySum(pageNumberSplit));
	}

	public static int maxMultiplySum(String[] pageNumberSplit) {
		int multiplySum = INIT_ONE.getNumber();

		for (String number : pageNumberSplit) {
			multiplySum *= Integer.parseInt(number);
		}

		return multiplySum;
	}

	public static int maxPlusSum(String[] pageNumberSplit) {
		int plusSum = INIT_ZERO.getNumber();

		for (String number : pageNumberSplit) {
			plusSum += Integer.parseInt(number);
		}

		return plusSum;
	}

	public static int makeWinner(int pobiMax, int crongMax) {
		if (pobiMax < crongMax) {
			return CRONG_WIN.getResult();
		}
		if (pobiMax > crongMax) {
			return POBI_WIN.getResult();
		}
		return DRAW.getResult();
	}
}