package onboarding.problem1;

import java.util.List;

public class MaxOfAddOrMultiplyDigitToSum {

	public static int maxOf(List<Integer> list) {
		int answer = 0;
		for (Integer n : list) {
			int temp = Math.max(AddEachDigitToSum.calculate(n), MultiplyDigitToSum.calculate(n));
			answer = Math.max(temp, answer);
		}
		return answer;
	}
}
