package onboarding.problem1;

import static java.lang.Math.*;

import java.util.ArrayList;
import java.util.List;

public class Pages {

	private final List<Page> pages;

	public Pages(List<Integer> pageNumbers) {
		validateBothSideExists(pageNumbers);
		validateConsecutive(pageNumbers);
		validateOrder(pageNumbers);

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

	private void validateBothSideExists(List<Integer> pageNumbers) {
		if (pageNumbers.size() != 2) {
			throw new IllegalArgumentException("양쪽 페이지가 있어야합니다");
		}
	}

	private void validateConsecutive(List<Integer> pageNumbers) {
		int diff = abs(pageNumbers.get(0) - pageNumbers.get(1));
		if (diff != 1) {
			throw new IllegalArgumentException("페이지가 연속적이지 않습니다");
		}
	}

	private void validateOrder(List<Integer> pageNumbers) {
		if (pageNumbers.get(0) % 2 == 0) {
			throw new IllegalArgumentException("좌측 페이지는 홀수여야 합니다");
		}
		if (pageNumbers.get(1) % 2 == 1) {
			throw new IllegalArgumentException("우측 페이지는 짝수여야 합니다");
		}
	}
}
