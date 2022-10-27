package onboarding.problem1.validation;

import onboarding.problem1.collection.Pages;

public class PageValidator {
	public static final int PAGE_MAX_LIMIT = 400;
	public static final int PAGE_MIN_LIMIT = 1;

	public static boolean isInValidPages(Pages pages) {
		return isPageSeparated(pages) || isPageLastOrHigher(pages) || isPageFirstOrLower(pages);
	}

	private static boolean isPageSeparated(Pages pages) {
		return (pages.getBackPage().getNumber() - pages.getFrontPage().getNumber()) != 1;
	}

	private static boolean isPageLastOrHigher(Pages pages) {
		return PAGE_MAX_LIMIT <= pages.getBackPage().getNumber();
	}

	private static boolean isPageFirstOrLower(Pages pages) {
		return pages.getFrontPage().getNumber() <= PAGE_MIN_LIMIT;
	}
}
