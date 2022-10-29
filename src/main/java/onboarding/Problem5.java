package onboarding;

import java.util.List;

public class Problem5 {
	private static int moneyCount(int myMoney, int moneyType) {
		return myMoney / moneyType;
	}

	public static List<Integer> solution(int money) {
		List<Integer> answer = new java.util.ArrayList<>();
		int[] moneyTypes = {50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1};
		//for (int i = 0; i < moneyTypes.length; i++) {
		for (int nowMoney : moneyTypes) {
			answer.add(moneyCount(money, nowMoney));
			money %= nowMoney;
		}
		return answer;
	}
}
