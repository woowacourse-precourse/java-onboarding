package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem5 {

	public static List<Integer> solution(int money) {
		Integer[] moneyArray = new Integer[9];
		int[] moneyUnit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
		for (int i = 0; i < 9; i++) {
			moneyArray[i] = money / moneyUnit[i];
			money %= moneyUnit[i];
		}

		return Arrays.asList(moneyArray);
	}

}
