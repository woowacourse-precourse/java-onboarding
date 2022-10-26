package onboarding.problem1;

import java.util.ArrayList;
import java.util.List;

public class Pages {

	private final List<Page> pages;

	public Pages(List<Integer> pageNumbers) {
		List<Page> pages = new ArrayList<>();
		for (Integer pageNumber : pageNumbers) {
			pages.add(new Page(pageNumber));
		}
		this.pages = pages;
	}

	public int calculateScore() {
		int maximum = 0;
		for (Page page : pages) {
			maximum = Math.max(maximum, page.calculateScore());
		}
		return maximum;
	}
}
