package onboarding;

import java.util.List;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;
		answer = pageNumberGame(pobi, crong);
		return answer;
	}

	public static int pageNumberGame(List<Integer> pobi, List<Integer> crong) {
		if (!InputValidator.isRightPagesInput(pobi, crong)) {
			return -1;
		}
		int pobiMaxPageNumber = getMaxPageNumber(pobi);
		int crongMaxPageNumber = getMaxPageNumber(crong);
		return getPageGameResult(pobiMaxPageNumber, crongMaxPageNumber);
	}

	public static int getPageGameResult(Integer pageNumber1, Integer pageNumber2) {

		if (pageNumber1 > pageNumber2) {
			return 1;
		} else if (pageNumber1 < pageNumber2) {
			return 2;
		} else if (pageNumber1 == pageNumber2) {
			return 0;
		}
		return -1;
	}

	public static int getMaxPageNumber(List<Integer> pages) {
		int maxNumber = 0;
		for (int page : pages) {
			maxNumber = getMaxNumber(page);
		}
		return maxNumber;
	}

	private static int getMaxNumber(Integer page) {
		return Math.max(addNumber(page), multiplyNumber(page));
	}

	private static int addNumber(Integer page) {
		int result = 0;
		while (page > 0) {
			result += page % 10;
			page /= 10;
		}
		return result;
	}

	private static int multiplyNumber(Integer page) {
		int result = 1;
		while (page > 0) {
			result *= page % 10;
			page /= 10;
		}
		return result;
	}

	static class InputValidator {
		public static boolean isRightPagesInput(List<Integer> pobi, List<Integer> crong) {
			if (isRightPage(pobi) && isRightPage(crong)) {
				return true;
			}
			return false;
		}

		private static boolean isRightPage(List<Integer> pages) {
			if (isRightPagesLength(pages) && isRightPageRange(pages) && isRightPagesOrder(pages) && !isFirstPage(pages)
				&& !isLastPage(pages)) {
				return true;
			}
			return false;
		}

		private static boolean isRightPagesLength(List<Integer> pages) {
			if (pages.size() != 2) {
				return false;
			}
			return true;
		}

		private static boolean isRightPageRange(List<Integer> pages) {
			for (int page : pages) {
				if (page < 1 || page > 400) {
					return false;
				}
			}
			return true;
		}

		private static boolean isRightPagesOrder(List<Integer> pages) {
			if (pages.get(0) % 2 == 1 && pages.get(1) % 2 == 0 && pages.get(1) - pages.get(0) == 1) {
				return true;
			}
			return false;
		}

		private static boolean isFirstPage(List<Integer> pages) {
			if (pages.get(0) == 1 && pages.get(1) == 2) {
				return true;
			}
			return false;
		}

		private static boolean isLastPage(List<Integer> pages) {
			if (pages.get(0) == 399 && pages.get(1) == 400) {
				return true;
			}
			return false;
		}
	}
}
