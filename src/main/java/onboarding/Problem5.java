package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
	public static final int[] BANKNOTE_UNIT =
			{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
	
	public static List<Integer> solution(int money) {
		List<Integer> answer = new ArrayList<>();
		int balance = money;
		for (int i = 0; i < BANKNOTE_UNIT.length; i++) {
			answer.add(unitCounting(balance, BANKNOTE_UNIT[i]));
			balance -= answer.get(i) * BANKNOTE_UNIT[i];
		}
		return answer;
	}
	public static int unitCounting(int money, int unit) {
		return money / unit;
	}
}
