package onboarding.problem5;

public enum MoneyUnit {
	FIFTY_THOUSAND(50000), TEN_THOUSAND(10000), FIVE_THOUSAND(5000), ONE_THOUSAND(1000),
	FIVE_HUNDRED(500), ONE_HUNDRED(100), FIFTY(50), TEN(10), ONE(1);

	private final int unit;

	MoneyUnit(int unit) {
		this.unit = unit;
	}

	public int getUnit() {
		return this.unit;
	}

	public int getCount(int money) {
		return money / unit;
	}
}
