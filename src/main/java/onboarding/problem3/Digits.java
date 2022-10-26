package onboarding.problem3;

import java.util.ArrayList;
import java.util.List;

public class Digits {

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
		return digit == 3 || digit == 6 || digit == 9;
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
