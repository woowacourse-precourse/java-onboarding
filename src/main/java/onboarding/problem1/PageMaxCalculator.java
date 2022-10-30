package onboarding.problem1;

import java.util.List;

public class PageMaxCalculator {
	public int findMax(List<Integer> pages) {
		PagePlusCalculator pagePlusCalculator = new PagePlusCalculator();
		PageMultiplyCalculator pageMultiplyCalculator = new PageMultiplyCalculator();
		return pages.stream()
			.map(page -> Math.max(pagePlusCalculator.calculate(page), pageMultiplyCalculator.calculate(page)))
			.max(Integer::compare).get();
	}
}
