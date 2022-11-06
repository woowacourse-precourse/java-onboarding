package onboarding.pagenumbergame;

import java.util.function.IntBinaryOperator;

public class Page {

	private final int number;

	public Page(final int number) {
		this.number = number;
	}

	public int getScore() {
		int sumOfDigits = calculate(Integer::sum);
		int productOfDigits = calculate((n1, n2) -> n1 * n2);
		return Math.max(sumOfDigits, productOfDigits);
	}

	private int calculate(final IntBinaryOperator operation) {
		return String.valueOf(number)
			.chars()
			.map(Character::getNumericValue)
			.reduce(operation)
			.orElse(0);
	}
}
