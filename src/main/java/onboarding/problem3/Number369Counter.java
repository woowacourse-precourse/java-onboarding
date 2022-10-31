package onboarding.problem3;

import java.util.List;

public class Number369Counter {
	public static final int TEN = 10;
	private final List<Integer> numberList = List.of(3, 6, 9);
	public int getFirstCount(int number) {
		int count = 0;
		while (number >0) {
			count = getFirstCount(number, count);
			number /= 10;
		}
		return count;
	}

	private int getFirstCount(int number, int count) {
		if (numberList.contains(number % TEN)){
			count++;
		}
		return count;
	}
}
