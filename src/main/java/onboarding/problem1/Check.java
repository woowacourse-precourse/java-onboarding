package onboarding.problem1;

import java.util.List;

public class Check {
	private final static int MINPAGE = 1;
	private final static int MAXPAGE = 400;
	private final static int limit = 2;
	public static boolean checkPageNumber(List<Integer> pages) {
		if (pages == null){
			return false;
		}

		if (pages.size() != limit) {
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
