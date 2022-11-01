package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

	public static final int EXCEPTION = -1;

	public static List<Integer> solution(int money) {
		List<Integer> answer = new ArrayList<>(Collections.emptyList());
		int[] units = new int[] {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

		if (checkRestrictions(money) == EXCEPTION) {
			return answer;
		}

		for (int unit : units) {
			answer.add(money / unit);
			money %= unit;
		}

		return answer;
	}

	/**
	 * 제한사항을 위배했는지 체크하는 메서드
	 * @param money
	 * @return
	 */
	private static Integer checkRestrictions(int money) {
		if (!isMoneyRangeValid(money)) {
			return EXCEPTION;
		}
		return 0;
	}

	// money 가 1 이상 1,000,000 이하인 자연수가 아닌 경우 예외
	private static boolean isMoneyRangeValid(int money) {
		if (money < 1 || money > 1000000) {
			return false;
		}
		return true;
	}
}
