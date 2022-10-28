package onboarding.problem1.validation;

import onboarding.problem1.vo.Pages;

public class PageValidator {
	public static final int PAGE_MAX_LIMIT = 400;
	public static final int PAGE_MIN_LIMIT = 1;

	public static boolean isInValidPages(Pages pages) {
		return isPageSeparated(pages) ||
				isLeftPageNotOdd(pages) ||
				isPageLastOrHigher(pages) ||
				isPageFirstOrLower(pages);
	}

	private static boolean isPageSeparated(Pages pages) {
		Integer higherPageNumber = Math.max(pages.getLeftPage().getNumber(), pages.getRightPage().getNumber());
		Integer lowerPageNumber = Math.min(pages.getLeftPage().getNumber(), pages.getRightPage().getNumber());
		return (higherPageNumber - lowerPageNumber) != 1;
	}

	private static boolean isLeftPageNotOdd(Pages pages) {
		return (pages.getLeftPage().getNumber() % 2) == 0;
	}

	private static boolean isPageLastOrHigher(Pages pages) {
		return PAGE_MAX_LIMIT <= pages.getLeftPage().getNumber() || PAGE_MAX_LIMIT <= pages.getRightPage().getNumber();
	}

	private static boolean isPageFirstOrLower(Pages pages) {
		return pages.getLeftPage().getNumber() <= PAGE_MIN_LIMIT || pages.getRightPage().getNumber() <= PAGE_MIN_LIMIT;
	}
}
