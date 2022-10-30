package onboarding.problem3.domain;

import java.util.List;

/**
 * Created by ShinD on 2022/10/27.
 */
public class NumberCounter {

	List<Integer> countedNumbers;

	public NumberCounter(List<Integer> countedNumbers) {
		this.countedNumbers = countedNumbers;
	}

	public int count(Number number) {
		int result = 0;
		int value = number.value();

		for (int i = 1; i <= value; i++) {
			result += Number.valueOf(i).countContainNumber(countedNumbers);
		}
		return result;
	}
}
