package onboarding;

import java.util.List;

class Problem1 {
	private final static int MINPAGE = 1;
	private final static int MAXPAGE = 400;

	public static int solution(List<Integer> pobi, List<Integer> crong) {
		if (!checkPageNumber(pobi) || !checkPageNumber(crong)) {
			return -1;
		}
		return Integer.MAX_VALUE;
	}

	public static boolean checkPageNumber(List<Integer> pages) {
		int limitPage = 2;
		if (pages.size() != limitPage) {
			return false;
		}

		if (pages.get(1) - pages.get(0) != 1) {
			return false;
		}

		if (pages.get(0) <= MINPAGE || pages.get(1) >= MAXPAGE) {
			return false;
		}

        return pages.get(0) % 2 == 1;
    }
}
