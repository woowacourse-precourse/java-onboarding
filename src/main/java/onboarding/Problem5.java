package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5 {

	public static final List<int[]> moneyAmounts = List.of(new int[] {50000, 21}, new int[] {10000, 5},
		new int[] {5000, 2}, new int[] {1000, 5}, new int[] {500, 2}, new int[] {100, 5}, new int[] {50, 2},
		new int[] {10, 5}, new int[] {1, 10});

	public static List<Integer> solution(int money) {
		List<Integer> answer = Collections.emptyList();

		try {
			isValidMoney(money);
		} catch (IllegalStateException moneyIsNotValidException) {
			moneyIsNotValidException.printStackTrace();
			return answer;
		}

		answer = countMoney(money);

		return answer;
	}

	public static void isValidMoney(int money) throws IllegalStateException {
		if (money < 1 || money > 1000000)
			throw new IllegalStateException("money의 범위가 올바르지 않습니다.");
	}

	public static List<Integer> countMoney(int money) {
		return moneyAmounts.stream().map(amount -> getMoneyCount(money, amount)).collect(Collectors.toList());
	}

	public static int getMoneyCount(int money, int[] amount) {
		return (money / amount[0]) % amount[1];
	}

	public static void main(String[] args) {
		System.out.println(countMoney(50000).toString());
	}
}
