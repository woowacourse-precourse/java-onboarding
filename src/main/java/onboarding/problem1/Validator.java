package onboarding.problem1;

import java.util.List;

public class Validator {
	public static void validate(List<Integer> integers) throws IllegalArgumentException {
		isTwoPages(integers);
		isConsecution(integers);
		isOddAndEvenPage(integers);
	}

	public static void isTwoPages(List<Integer> integers) throws IllegalArgumentException {
		if (integers.size() != 2) {
			throw new IllegalArgumentException();
		}
	}

	public static void isConsecution(List<Integer> integers) throws IllegalArgumentException {
		if (integers.get(0) + 1 != integers.get(1)) {
			throw new IllegalArgumentException();
		}
	}

	public static void isOddAndEvenPage(List<Integer> integers) throws IllegalArgumentException {
		if (integers.get(0) % 2 == 0 || integers.get(1) % 2 == 1) {
			throw new IllegalArgumentException();
		}
	}
}
