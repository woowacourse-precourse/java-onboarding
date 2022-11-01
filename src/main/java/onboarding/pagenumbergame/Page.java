package onboarding.pagenumbergame;

import static onboarding.pagenumbergame.GameResult.*;

import java.util.List;
import java.util.function.IntBinaryOperator;

public class Page {
	private final List<Integer> pageNumbers;

	public Page(List<Integer> pageNumbers) {
		this.pageNumbers = pageNumbers;
	}

	public int compare(final Page other) {
		if (isInvalidPage() || other.isInvalidPage()) {
			return EXCEPTION;
		}
		int page1Score = getMaximumScore();
		int page2Score = other.getMaximumScore();

		if (page1Score == page2Score) {
			return DRAW;
		}
		return page1Score > page2Score
			? WIN
			: LOSE;
	}

	private boolean isInvalidPage() {
		return !ValidationUtils.validatePage(pageNumbers);
	}

	public int getMaximumScore() {
		return pageNumbers.stream()
			.map(this::getMaximumNumberOf)
			.max(Integer::compareTo)
			.orElse(0);
	}

	int getMaximumNumberOf(int pageNumber) {
		int sumOfDigits = calculate(pageNumber, Integer::sum);
		int productOfDigits = calculate(pageNumber, (n1, n2) -> n1 * n2);
		return Math.max(sumOfDigits, productOfDigits);
	}

	private static int calculate(final int number,
		final IntBinaryOperator operation) {

		return String.valueOf(number)
			.chars()
			.map(Character::getNumericValue)
			.reduce(operation)
			.orElse(0);
	}
}
