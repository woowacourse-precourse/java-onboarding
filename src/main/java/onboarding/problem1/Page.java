package onboarding.problem1;

import java.util.ArrayList;
import java.util.List;

public class Page {

	private final int pageNumber;

	public Page(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int addAllDigits() {
		int result = 0;
		for (int digit : disassemble(pageNumber)) {
			result += digit;
		}
		return result;
	}

	public int multiplyAllDigits() {
		int result = 1;
		for (int digit : disassemble(pageNumber)) {
			result *= digit;
		}
		return result;
	}

	private List<Integer> disassemble(int number) {
		List<Integer> disassembledNumber = new ArrayList<>();
		int left = number;
		do {
			int digit = left % 10;
			left = left / 10;
			disassembledNumber.add(digit);
		} while (left > 0);
		return disassembledNumber;
	}
}
