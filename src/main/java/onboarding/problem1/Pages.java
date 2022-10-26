package onboarding.problem1;

import static java.lang.Math.*;

import java.util.ArrayList;
import java.util.List;

public class Pages {

	private final List<Page> pages;

	public Pages(List<Integer> pageNumbers) {
		validateConsecutive(pageNumbers);

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

	private void validateConsecutive(List<Integer> pageNumbers) {
		int diff = abs(pageNumbers.get(0) - pageNumbers.get(1));
		if (diff != 1) {
			throw new IllegalArgumentException("페이지가 연속적이지 않습니다");
		}
	}
}
