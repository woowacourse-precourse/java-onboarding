package onboarding;

import java.util.List;

import onboarding.problem5.Bank;

public class Problem5 {

	private static final List<Integer> AMOUNTS = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

	public static List<Integer> solution(int money) {
		Bank bank = new Bank(AMOUNTS);
		return bank.withdraw(money);
	}
}
