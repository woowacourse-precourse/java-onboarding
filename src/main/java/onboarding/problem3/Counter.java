package onboarding.problem3;

import java.util.ArrayList;
import java.util.List;

public class Counter {

	public int countTotal369(int number) {
		int result = 0;
		for(int i = 1; i <= number; i++) {
			result += count369(i);
		}
		return result;
	}

	private int count369(int number) {
		List<Integer> numberList = new ArrayList<>();
		int result = 0;

		while (number > 0) {
			numberList.add(number % 10);
			number = number / 10;
		}

		for (int n : numberList) {
			if (n > 0 && n % 3 == 0) {
				result += 1;
			}
		}
		return result;
	}
}
