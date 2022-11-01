package onboarding.problem5;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Account {
	private int budget;

	public Account(int budget) {
		this.budget = budget;
	}

	public List<Integer> withdraw() {
		MoneyUnit[] moneyUnits = MoneyUnit.values();
		return Arrays.stream(moneyUnits)
			.map(this::withdraw)
			.collect(Collectors.toList());
	}

	public int withdraw(MoneyUnit moneyUnit) {
		int count = moneyUnit.getCount(budget);
		budget %= moneyUnit.getUnit();
		return count;
	}
}
