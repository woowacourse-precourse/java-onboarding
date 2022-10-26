package onboarding.problem1;

import java.util.ArrayList;
import java.util.List;

public class Digits {

	private final List<Digit> digits;

	public Digits(int number) {
		this.digits = disassemble(number);
	}

	public int addAllDigits() {
		Digit result = new Digit(0);
		for (Digit digit : digits) {
			result = result.add(digit);
		}
		return result.value();
	}

	public int multiplyAllDigits() {
		Digit result = new Digit(1);
		for (Digit digit : digits) {
			result = result.multiply(digit);
		}
		return result.value();
	}

	private List<Digit> disassemble(int number) {
		List<Digit> digits = new ArrayList<>();
		int left = number;
		do {
			int digit = left % 10;
			left = left / 10;
			digits.add(new Digit(digit));
		} while (left > 0);
		return digits;
	}
}
