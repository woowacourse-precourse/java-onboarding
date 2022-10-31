package onboarding.problem1;

import java.util.List;

public class PageGame {
	private final BookPage pobi;
	private final BookPage crong;

	public PageGame(List<Integer> pobi, List<Integer> crong) {
		this.pobi = new BookPage(pobi);
		this.crong = new BookPage(crong);
	}

	public int result() {
		if (pobi.compareTo(crong) > 0) {
			return 1;
		}
		if (pobi.compareTo(crong) < 0) {
			return 2;
		}
		if (pobi.compareTo(crong) == 0) {
			return 0;
		}
		return -1;
	}
}
