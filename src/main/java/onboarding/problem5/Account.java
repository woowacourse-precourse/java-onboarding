package onboarding.problem5;

public class Account {
	private int budget;

	public Account(int budget) {
		this.budget = budget;
	}

	public int withdraw(MoneyUnit moneyUnit) {
		int count = moneyUnit.getCount(budget);
		budget %= moneyUnit.getUnit();
		return count;
	}
}
