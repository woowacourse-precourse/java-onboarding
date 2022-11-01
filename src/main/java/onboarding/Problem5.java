package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
	public static List<Integer> solution(int money) {
		int withdrawalMoney = money;
		int[] monetaryUnit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
		List<Integer> eachUnitNumberToGive = new ArrayList<>(monetaryUnit.length);

		for (int unit : monetaryUnit) {
			eachUnitNumberToGive.add(getMinimumNumberOfUnit(withdrawalMoney, unit));
			withdrawalMoney = getNextMoney(withdrawalMoney, unit);
		}

		return eachUnitNumberToGive;
	}

	private static int getMinimumNumberOfUnit(int withdrawalMoney, int unit) {
		return withdrawalMoney / unit;
	}

	private static int getNextMoney(int previousMoney, int unit) {
		return previousMoney % unit;
	}
}
