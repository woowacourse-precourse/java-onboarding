package onboarding.problem1;

import java.util.ArrayList;
import java.util.List;

public class Digits {

	private final List<Integer> digits;

	public Digits(int number) {
		this.digits = disassemble(number);
	}

	public int addAllDigits() {
		int result = 0;
		for (Integer digit : digits) {
			result = result + digit;
		}
		return result;
	}

	public int multiplyAllDigits() {
		int result = 1;
		for (Integer digit : digits) {
			result = result * digit;
		}
		return result;
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
