package onboarding.problem1.domain;

import java.util.List;

public class PagePair {

	private final Page left;

	private final Page right;

	public PagePair(List<Integer> pages) {
		this.left = new Page(pages.get(0));
		this.right = new Page(pages.get(1));
	}


	public boolean isOutOfRange(int low, int upper) {
		return (left.isOutOfRange(low, upper))
				|| (right.isOutOfRange(low, upper));
	}

	public boolean isNotConsecutiveOddEven() {
		if (right.interval(left) != 1) {
			return true;
		}
		return !left.isOdd() || !right.isEven();
	}
}
