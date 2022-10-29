package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
	public static List<Integer> solution(int money) {
		int withdrawalMoney = money;
		int[] monetaryUnit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
		List<Integer> unitCount = new ArrayList<>(monetaryUnit.length);

		for (int i = 0; i < monetaryUnit.length; i++) {
			unitCount.add(withdrawalMoney / monetaryUnit[i]);
			withdrawalMoney %= monetaryUnit[i];
		}

		return unitCount;
	}
}
