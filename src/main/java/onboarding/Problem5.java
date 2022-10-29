package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
	public static List<Integer> solution(int money) {
		int withdrawalMoney = money;
		int[] monetaryUnit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
		List<Integer> unitCount = new ArrayList<>(monetaryUnit.length);

		for (int i : monetaryUnit) {
			unitCount.add(minUnitNumber(withdrawalMoney, i));
			withdrawalMoney = getNextMoney(withdrawalMoney, i);
		}

		return unitCount;
	}

	private static int minUnitNumber(int withdrawalMoney, int unit) {
		return withdrawalMoney / unit;
	}

	private static int getNextMoney(int previousMoney, int unit) {
		return previousMoney % unit;
	}
}
