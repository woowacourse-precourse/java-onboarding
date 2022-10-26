package onboarding;

import java.util.List;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		if (checkPages(pobi) || checkPages(crong)) {
			return -1;
		}
		int pobiMaxPage = maxOf(pobi);
		int crongMaxPage = maxOf(crong);

		if (pobiMaxPage == crongMaxPage) {
			return 0;
		}

		return pobiMaxPage > crongMaxPage ? 1 : 2;
	}

	private static boolean checkPages(List<Integer> list) {
		if (list.size() != 2) {
			return true;
		}
        return list.get(1) - list.get(0) != 1;
    }

	private static int maxOf(List<Integer> pages) {
		int max = 0;
		for (Integer page : pages) {
			int pageMax = maxOf(page);
			max = Math.max(pageMax, max);
		}
		return max;
	}

	private static int maxOf(Integer page) {
		int plusSumNum = plusSum(page);
		int multiplicationSumNum = multiplySum(page);

		return Math.max(plusSumNum, multiplicationSumNum);
	}

	private static int multiplySum(Integer page) {
		int sum = 1;
		while (page > 0) {
			sum *= page % 10;
			page /= 10;
		}
		return sum;
	}

	private static int plusSum(Integer page) {
		int sum = 0;
		while (page > 0) {
			sum += page % 10;
			page /= 10;
		}
		return sum;
	}
}
