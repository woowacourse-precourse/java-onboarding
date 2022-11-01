package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

	public static List<Integer> solution(int money) {
		try {
			validate(money);
			List<Integer> answer = Bank.getMoneyCountList(money);
			return answer;
		} catch (Exception e) {
			System.out.println(e);
			return Collections.emptyList();
		}

	}

	static void validate(int money) throws Exception {
		if (money < 1 || money > 1_000_000) {
			throw new Exception("1 이상 1000000 이하의 자연수만 입력 받을 수 있습니다");
		}
	}
}

class Bank {

	private static final int[] moneyArray = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

	static List<Integer> getMoneyCountList(int money) {
		List<Integer> moneyCountList = new ArrayList<>();
		int countTimes = moneyArray.length;
		int count;
		int changes = money;
		for (int i = 0; i < countTimes; i++) {
			count = changes / moneyArray[i];
			changes = changes % moneyArray[i];
			moneyCountList.add(count);
		}
		return moneyCountList;
	}

}