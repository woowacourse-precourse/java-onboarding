package onboarding;

import java.util.List;

import onboarding.problem1.Page;
import onboarding.problem1.PageComparator;

class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		PageComparator comparator = new PageComparator();

		try {
			Page pobiPage = new Page(pobi);
			Page crongPage = new Page(crong);

			Integer pobiMaxValue = comparator.getMaxPageValue(pobiPage);
			Integer crongMaxValue = comparator.getMaxPageValue(crongPage);

			return comparator.compare(pobiMaxValue, crongMaxValue);
		} catch (Exception e) {
			System.out.println("Exception - PROBLEM1: " + e.getMessage());
			return -1;
		}
	}
}
