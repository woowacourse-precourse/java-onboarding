package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5 {
	public static List<Integer> solution(int money) {
		return returnResultList(money);
	}

	private static List<Integer> returnResultList(int money) {
		List<Integer> monetaryUnitList = new ArrayList<>(Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));
		List<Integer> resultList = new ArrayList<>();
		for (int monetaryUnit : monetaryUnitList) {
			resultList.add(exchange(money, monetaryUnit));
			money -= exchange(money, monetaryUnit) * monetaryUnit;
		}
		return resultList;
	}

	private static int exchange(int money, int monetaryUnit) {
		return money / monetaryUnit;
	}
}
