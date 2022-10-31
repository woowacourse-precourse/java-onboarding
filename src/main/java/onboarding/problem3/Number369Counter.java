package onboarding.problem3;

import java.util.List;

public class Number369Counter {
	private final List<Integer> numberList = List.of(3, 6, 9);
	public int count(int number) {
		int count = 0;
		while (number >0) {
			count = getCount(number, count);
			number /= 10;
		}
		return count;
	}

	private int getCount(int number, int count) {
		if (numberList.contains(number % 10)){
			count++;
		}
		return count;
	}
}
