package onboarding.problem5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bank {

	private final List<Integer> amounts;

	public Bank(List<Integer> amounts) {
		ArrayList<Integer> sortedAmounts = new ArrayList<>(amounts);
		sortedAmounts.sort(Comparator.reverseOrder());
		this.amounts = sortedAmounts;
	}

	public List<Integer> withdraw(int balance) {
		List<Integer> counts = new ArrayList<>();
		int left = balance;
		for (Integer amount : amounts) {
			counts.add(left / amount);
			left = left % amount;
		}
		return counts;
	}
}
