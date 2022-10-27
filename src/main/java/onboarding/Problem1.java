package onboarding;

import java.util.List;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;
		return answer;
	}

	static class InputValidator {
		public static boolean isRightPagesInput(List<Integer> pobi, List<Integer> crong) {
			if (isRightPage(pobi) && isRightPage(crong)) {
				return true;
			}
			return false;
		}

		public static boolean isRightPage(List<Integer> pages) {
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
