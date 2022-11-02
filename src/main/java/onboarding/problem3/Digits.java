package onboarding.problem3;

import java.util.ArrayList;
import java.util.List;

public class Digits {

	private static final int THREE = 3;
	private static final int SIX = 6;
	private static final int NINE = 9;

	private final List<Integer> digits;

	public Digits(int number) {
		this.digits = disassemble(number);
	}

	public int countThreeSixNine() {
		int count = 0;
		for (Integer digit : digits) {
			if (isThreeSixNine(digit)) {
				count++;
			}
		}
		return count;
	}

	private boolean isThreeSixNine(int digit) {
		return digit == THREE || digit == SIX || digit == NINE;
	}

	private List<Integer> disassemble(int number) {
		List<Integer> digits = new ArrayList<>();
		int left = number;
		do {
			int digit = left % 10;
			left = left / 10;
			digits.add(digit);
		} while (left > 0);
		return digits;
	}
}
