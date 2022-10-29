package onboarding.billcounter;

public enum BillUnit {
	FIFTY_THOUSAND_WON(50_000),
	TEN_THOUSAND_WON(10_000),
	FIVE_THOUSAND_WON(5_000),
	THOUSAND_WON(1_000),
	FIVE_HUNDRED_WON(500),
	HUNDRED_WON(100),
	TEN_WON(10),
	ONE_WON(1);

	private final int money;

	BillUnit(int money) {
		this.money = money;
	}

	public int getMoney() {
		return money;
	}
}
