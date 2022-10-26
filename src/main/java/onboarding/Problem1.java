package onboarding;

import java.util.List;
import java.util.NoSuchElementException;

class Problem1 {

	public static final int POBI_WIN = 1;
	public static final int CRONG_WIN = 2;
	public static final int DRAW = 0;
	public static final int ERROR = -1;

	public static int solution(List<Integer> pobi, List<Integer> crong) {
		if (checkIrregularPages(pobi) || checkIrregularPages(crong)) {
			return ERROR;
		}
		Integer pobiMaxPage = getMaxPage(pobi);
		Integer crongMaxPage = getMaxPage(crong);
		return pickWinner(pobiMaxPage, crongMaxPage);
	}

	private static boolean checkIrregularPages(List<Integer> pages) {
		if (pages.get(0) == null || pages.get(1) == null) {
			return true;
		}
		return pages.get(0) - pages.get(1) != -1;
	}

	private static Integer getMaxPage(List<Integer> pages) {
		return pages.stream()
				.map(Problem1::compareMaxPage)
				.max(Integer::compareTo)
				.orElseThrow(NoSuchElementException::new);
	}

	private static int compareMaxPage(Integer page) {
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

	private static int pickWinner(Integer pobiPage, Integer crongPage) {
		if (pobiPage > crongPage) {
			return POBI_WIN;
		}
		if (pobiPage < crongPage) {
			return CRONG_WIN;
		}
		return DRAW;
	}
}
