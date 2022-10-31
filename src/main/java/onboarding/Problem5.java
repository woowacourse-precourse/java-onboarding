package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
	static final List<Integer> typeOfMoney = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

	public static List<Integer> solution(int money) {

		List<Integer> answer = new ArrayList<>();
	
		for (int a : typeOfMoney) {
			answer.add(withdrawMoney(money, a));
			money = updateMoney(money, a);
		}
		return answer;
    }

	private static int withdrawMoney(int money, int won) {
		return money / won;
	}

	private static int updateMoney(int money, int won) {
		return money % won;
	}
}
