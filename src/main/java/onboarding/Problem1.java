package onboarding;

import java.util.List;

import onboarding.problem1.CheckPages;
import onboarding.problem1.MaxOfAddOrMultiplyDigitToSum;

class Problem1 {


	public static int solution(List<Integer> pobi, List<Integer> crong) {
		if (!CheckPages.of(pobi) || !CheckPages.of(crong)) {
			return -1;
		}
		int pobiMaxNumber = MaxOfAddOrMultiplyDigitToSum.maxOf(pobi);
		int crongMaxNumber = MaxOfAddOrMultiplyDigitToSum.maxOf(crong);

		if (pobiMaxNumber == crongMaxNumber) {
			return 0;
		}
		return pobiMaxNumber > crongMaxNumber ? 1: 2;

	}


}
