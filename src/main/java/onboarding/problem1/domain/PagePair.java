package onboarding.problem1.domain;

import java.util.List;
import java.util.function.BinaryOperator;

import static java.lang.Integer.max;

public class PagePair {

	private static final BinaryOperator<Integer> ADD = Integer::sum;

	private static final int ADD_INIT_VALUE = 0;

	private static final BinaryOperator<Integer> MULTIPLY = (a, b) -> a * b;

	private static final int MULTIPLY_INIT_VALUE = 1;

	private final Page left;

	private final Page right;

	public PagePair(List<Integer> pages) {
		this.left = new Page(pages.get(0));
		this.right = new Page(pages.get(1));
	}


	public boolean isOutOfRange(int low, int upper) {
		return (left.isOutOfRange(low, upper))
				|| (right.isOutOfRange(low, upper));
	}

	public boolean isNotConsecutiveOddEven() {
		if (right.interval(left) != 1) {
			return true;
		}
		return !left.isOdd() || !right.isEven();
	}

	public int totalScore() {
		int leftScore = max(
				left.scoreByOperator(ADD, ADD_INIT_VALUE),
				left.scoreByOperator(MULTIPLY, MULTIPLY_INIT_VALUE));

		int rightScore = max(
				right.scoreByOperator(ADD, ADD_INIT_VALUE),
				right.scoreByOperator(MULTIPLY, MULTIPLY_INIT_VALUE));

		return leftScore + rightScore;
	}
}
