package onboarding;

import java.util.List;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;

		if (checkIrregularPages(pobi) || checkIrregularPages(crong)) {
			return -1;
		}

		Integer pobiMax = pobi.stream()
				.map(Problem1::getMaxPage)
				.max(Integer::compareTo)
				.orElse(-1);

		Integer crongMax = crong.stream()
				.map(Problem1::getMaxPage)
				.max(Integer::compareTo)
				.orElse(-1);

		if (pobiMax > crongMax) {
			return 1;
		}
		if (pobiMax < crongMax) {
			return 2;
		}
		return 0;
	}

	private static boolean checkIrregularPages(List<Integer> pages) {
		return pages.get(0) - pages.get(1) != -1;
	}

	private static int getMaxPage(Integer page) {
		int sum = 0;
		int mul = 1;
		int temp;
		while (page > 0) {
			temp = page % 10;
			page /= 10;
			sum += temp;
			mul *= temp;
		}
		return Math.max(sum, mul);
	}
}