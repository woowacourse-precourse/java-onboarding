package onboarding.pagenumbergame;

import java.util.List;

public class PageValidationUtils {

	private static final int MIN_PAGE_NUMBER = 1;

	private static final int MAX_PAGE_NUMBER = 400;

	public static boolean validatePageNumber(final int pageNumber) {
		return MIN_PAGE_NUMBER < pageNumber
			&& pageNumber < MAX_PAGE_NUMBER;
	}

	public static boolean validatePageOrder(final List<Integer> pageNumbers) {
		int leftNumber = pageNumbers.get(0);
		int rightNumber = pageNumbers.get(1);
		return leftNumber < rightNumber
			&& leftNumber + 1 == rightNumber;
	}

	public static boolean validatePage(List<Integer> pageNumbers) {
		if (pageNumbers == null || pageNumbers.size() != 2) {
			return false;
		}
		return validatePageNumbers(pageNumbers)
			&& validatePageOrder(pageNumbers);
	}

	private static boolean validatePageNumbers(List<Integer> pageNumbers) {
		return pageNumbers.stream()
			.allMatch(PageValidationUtils::validatePageNumber);
	}
}
