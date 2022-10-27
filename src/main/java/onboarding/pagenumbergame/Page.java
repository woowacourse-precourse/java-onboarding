package onboarding.pagenumbergame;

import java.util.List;
import java.util.function.IntBinaryOperator;

public class Page {

	private final List<Integer> pageNumbers;

	public Page(List<Integer> pageNumbers) {
		this.pageNumbers = pageNumbers;
	}

	int getMaximumNumberFrom(int pageNumber) {
		int sumOfDigits = calculate(pageNumber, Integer::sum);
		int productOfDigits = calculate(pageNumber, (n1, n2) -> n1 * n2);
		return Math.max(sumOfDigits, productOfDigits);
	}

	private static int calculate(final int number,
		final IntBinaryOperator operation) {

		return String.valueOf(number)
			.chars()
			.map(num -> num - 48)
			.reduce(operation)
			.orElse(0);
	}

	public int getMaximumNumber() {
		return pageNumbers.stream()
			.map(this::getMaximumNumberFrom)
			.max(Integer::compareTo)
			.orElse(0);
	}

	public int compare(final Page other) {
		if (isInvalidPage() || other.isInvalidPage()) {
			return -1;
		}
		int pageNumber1 = getMaximumNumber();
		int pageNumber2 = other.getMaximumNumber();

		if (pageNumber1 == pageNumber2) {
			return 0;
		}
		return pageNumber1 > pageNumber2 ? 1 : 2;
	}

	private boolean isInvalidPage() {
		return !ValidationUtils.validatePage(pageNumbers);
	}
}
