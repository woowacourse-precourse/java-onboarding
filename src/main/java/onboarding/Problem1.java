package onboarding;

import java.util.List;

import onboarding.problem1.Check;

class Problem1 {


	public static int solution(List<Integer> pobi, List<Integer> crong) {
		if (!Check.checkPageNumber(pobi) || !Check.checkPageNumber(crong)) {
			return -1;
		}

		return Integer.MAX_VALUE;
	}


}
