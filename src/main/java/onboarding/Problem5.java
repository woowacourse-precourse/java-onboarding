package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5 {

	public static List<Integer> solution(int money) {
		List<Integer> moneyTypes = createMoneyTypes();
		List<Integer> answer = new ArrayList<>(moneyTypes.size());

		calculateMoneyCount(money, answer, moneyTypes);

		return answer;
	}

	private static List<Integer> createMoneyTypes() {
		return Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
	}

	private static void calculateMoneyCount(int money, List<Integer> answer, List<Integer> moneyTypes) {
		for (int moneyType : moneyTypes) {
			calculateEachTypeOfMoneyCount(money, answer, moneyType);
			money = getChanges(money, moneyType);
		}
	}

	private static void calculateEachTypeOfMoneyCount(int money, List<Integer> answer, int moneyType) {
		answer.add(money / moneyType);
	}

	private static int getChanges(int money, int moneyType) {
		return money % moneyType;
	}
}
