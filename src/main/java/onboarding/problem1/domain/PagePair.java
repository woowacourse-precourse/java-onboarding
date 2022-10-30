package onboarding.problem1.domain;

import java.util.List;

public class PagePair {

	private final Page left;

	private final Page right;

	public PagePair(List<Integer> pages) {
		this.left = new Page(pages.get(0));
		this.right = new Page(pages.get(1));
	}
}
