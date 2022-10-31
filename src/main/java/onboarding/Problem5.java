package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
	static final List<Integer> typeOfMoney = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

	public static List<Integer> solution(int money) {

		List<Integer> answer = new ArrayList<>();
	
		for (int change : typeOfMoney) {
			answer.add(withdrawMoney(money, change));
			money = updateMoney(money, change);
		}
		return answer;
    }

	private static int withdrawMoney(int money, int currency) {
		return money / currency;
	}

	private static int updateMoney(int money, int currency) {
		return money % currency;
	}
}
