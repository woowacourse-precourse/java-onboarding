package onboarding;

import java.util.List;

import onboarding.enums.problem1.InitNumber;
import onboarding.enums.problem1.Output;
import onboarding.enums.problem1.Page;

class Problem1 {

	public static int solution(List<Integer> pobi, List<Integer> crong) {
		if (isException(pobi) || isException(crong)) {
			return Output.EXCEPTION.getResult();
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
			if (pageNumber > Page.MAX_PAGE.getPage() || pageNumber < Page.MIN_PAGE.getPage()) {
				return true;
			}
		}
		return false;
	}

	private static boolean isPagePositionException(List<Integer> pageList) {
		return (pageList.get(Page.RIGHT_PAGE.getPage()) < pageList.get(Page.LEFT_PAGE.getPage()));
	}

	private static boolean isPageIntervalException(List<Integer> pageList) {
		return (pageList.get(Page.RIGHT_PAGE.getPage()) - pageList.get(Page.LEFT_PAGE.getPage())
			> Page.PAGE_INTERVAL.getPage());
	}

	public static int maxScore(List<Integer> pageList) {
		int max = InitNumber.INIT_ZERO.getNumber();

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
		int multiplySum = InitNumber.INIT_ONE.getNumber();

		for (String number : pageNumberSplit) {
			multiplySum *= Integer.parseInt(number);
		}

		return multiplySum;
	}

	public static int maxPlusSum(String[] pageNumberSplit) {
		int plusSum = InitNumber.INIT_ZERO.getNumber();

		for (String number : pageNumberSplit) {
			plusSum += Integer.parseInt(number);
		}

		return plusSum;
	}

	public static int makeWinner(int pobiMax, int crongMax) {
		if (pobiMax < crongMax) {
			return Output.CRONG_WIN.getResult();
		}
		if (pobiMax > crongMax) {
			return Output.POBI_WIN.getResult();
		}
		return Output.DRAW.getResult();
	}
}