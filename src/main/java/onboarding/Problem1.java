package onboarding;

import java.util.List;

class Problem1 {

	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int pobiMaxPagePoint = getMaxPage(pobi);
		int crongMaxPagePoint = getMaxPage(crong);
		if (pobiMaxPagePoint == -1 || crongMaxPagePoint == -1) {
			return Math.min(pobiMaxPagePoint, crongMaxPagePoint);
		}
		return compare(pobiMaxPagePoint, crongMaxPagePoint);
	}

	private static int compare(int x, int y) {
		return (x < y) ? 2 : ((x == y) ? 0 : 1);
	}

	private static int getMaxPage(List<Integer> pages) {
		if (checked(pages)) {
			return -1;
		}
		return Math.max(maximumValueOfSumAndMultiply(pages.get(0)), maximumValueOfSumAndMultiply(pages.get(1)));
	}

	private static boolean checked(List<Integer> pages) {
		return pages.size() > 2 || pages.get(0) >= pages.get(1) || pages.get(0) % 2 == 0 || pages.get(1) % 2 != 0
			|| (Math.abs(pages.get(0) - pages.get(1))) != 1;
	}

	private static int maximumValueOfSumAndMultiply(int pageNumber) {
		String num = String.valueOf(pageNumber);
		int sum = 0;
		int mul = 1;
		for (int i = 0; i < num.length(); i++) {
			sum += num.charAt(i) - '0';
			mul *= num.charAt(i) - '0';
		}
		return Math.max(sum, mul);
	}

}