package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
	public static final int[] BANKNOTE_UNIT =
			{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
	
	public static List<Integer> solution(int money) {
		List<Integer> answer = Collections.emptyList();
		answer = unitizing(money);
		return answer;
	}
	private static List<Integer> unitizing(int money) {
		List<Integer> unitizedMoney = new ArrayList<>();
		int balance = money;
		for(int i=0; i < BANKNOTE_UNIT.length; i++) {
			unitizedMoney.add(balance/BANKNOTE_UNIT[i]);
			balance -= unitizedMoney.get(i) * BANKNOTE_UNIT[i];
		}
		return unitizedMoney;
	}
}
